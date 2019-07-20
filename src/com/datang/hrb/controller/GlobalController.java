package com.datang.hrb.controller;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.datang.hrb.dao.ConnectionUtil;
import com.datang.hrb.service.LoginService;
import com.datang.hrb.service.Impl.LoginServiceImpl;
import com.datang.hrb.vo.User;

public class GlobalController extends HttpServlet {
	private Map<String, String> userMap = new HashMap<String, String>();
//在servlet中定义一个私有map变量，用于存储用户注册信息，这里用来存储username：password键值对
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("run in deget");
		// resp.setContentType("text/html;charset=UTF-8");
		// PrintWriter pw=resp.getWriter();
		// pw.write("<p style='color:red;'>恭喜，访问到后台</p>");
		// pw.flush();
		// pw.close();
		resp.sendRedirect("ok.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//先定义语言不然出现乱码
		String username = req.getParameter("username");//键值对输入到map
		String password = req.getParameter("password");
		// System.out.println("run in dopost");
		System.out.println("uri====" + req.getRequestURI());
		String uri = req.getRequestURI();//截取字段，URI是除去协议主机端口部分，就去/与.之间的字段开区间
		String action = uri.substring(uri.lastIndexOf("/") + 1, uri.indexOf("."));
		if (action.equals("register")) {
			
			//userMap.put(username, password);
			//resp.sendRedirect("register_success.jsp");这样输出不会永久保存重启就不见了
			Connection conn=ConnectionUtil.getConnection();
			try {
			PreparedStatement ps=conn.prepareStatement("insert into user(username,password) values(?,?)"); 
			ps.setString(1, username);
			ps.setString(2, password);
			int i=ps.executeUpdate();
			if(i==1)
			{
				resp.sendRedirect("register_success.jsp");}
				else {
					resp.sendRedirect("register_fail.jsp");
				}
				}catch(SQLException e) {
					resp.sendRedirect("register_fail.jsp");
					e.printStackTrace();
			
			
			}} else if (action.equals("login")) /*{
			LoginService loginService=new LoginServiceImpl();
				
				User user=new User();
				user.setUsername(username);
				user.setPassword(password);
				User dbuser=loginService.login(user);
				if(dbuser==null){
				resp.sendRedirect("login_fail");
				}else{HttpSession session=req.getSession();
					session.setAttribute("userList",userlist);
					resp.sendRedirect("login.jsp");}
			}
			
		*/
		
				
				{
				
				
				// resp.sendRedirect("ok.jsp");
			
			//String existPassword = userMap.get(username);
				Connection conn=ConnectionUtil.getConnection();
				PreparedStatement ps=null;
				HttpSession session =req.getSession();//获取session对象
				try {
					ps=conn.prepareStatement("select * from user where username=?");
					ps.setString(1, username);
					ResultSet rs =ps.executeQuery();
					if(rs!=null&&rs.next()) {
						String dbpwd=rs.getString(2);
						//密码一致登陆成功
						if(password.equals(dbpwd)) {
							session.setAttribute("username", username);
							//登陆成功后，使用session存储用户名，以供在页面展示用户名
							PreparedStatement ps_second=null;
							ps_second=conn.prepareStatement("select * from user");//查询所有数据
						//查询所有数据
							ResultSet rsList=ps_second.executeQuery();
							//定义泛型，存储返回的数据，这里使用了user对数据进行封装
							List<User>  userList=new ArrayList<User>();
							//遍历返回数据并将其储存到userlist中
							while(rsList.next()) {
								User user=new User();
								user.setUsername(rsList.getString(1));
								user.setAge(rsList.getInt(3));
								userList.add(user);
							}
							session.setAttribute("userList", userList);
							//将user存储到userlist中
							resp.sendRedirect("login.jsp");
						}else {resp.sendRedirect("login_fail.jsp");
						
						}}else {
							resp.sendRedirect("login_fail.jsp");
							
							
						}
					}catch(SQLException e) {
						resp.sendRedirect("login_fail.jsp");
						e.printStackTrace();
				}finally {
					if(ps!=null) {
						try {ps.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}}}}}
				//if (existPassword == null) {
				//resp.sendRedirect("login_fail.jsp");

			//} else {// 错误的请求
				//if (existPassword.equals(password)) {//密碼一致
					//resp.sendRedirect("login_success.jsp");
				//} else {
					//resp.sendRedirect("login_fail.jsp");

				//}
			//}
		//}

		//else {
		//}
	//}
//}
