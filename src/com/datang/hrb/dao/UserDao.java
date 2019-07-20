package com.datang.hrb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.datang.hrb.vo.User;

public class UserDao {
     public String getUserByUseername(String username) {
    	 Connection conn=ConnectionUtil.getConnection();
    	 PreparedStatement ps=null;
    	 String password=null;
    	 User user=null;
    	 try {ps=conn.prepareStatement("select * from user where username=?");
    	 ps.setString(1, username);
    	 ResultSet rs=ps.executeQuery();
    	//rs.next();
    	//password=rs.getString(2);
			
			  while(rs.next()) {
				  user.setUsername(rs.getString(1));
                   user.setPassword(rs.getString(2));
                   user.setAge(rs.getInt(3));
                   user.setTs(rs.getDate(4));
                   
                   
                   
			  
			  }
			 
    	 
    	 }catch(SQLException e){
    		 e.printStackTrace();}
    	 finally {
    		 if(ps!=null) {
    			 try {
    				 ps.close();//防止泄露数据
    			 }catch(SQLException e){
    	    		 e.printStackTrace();}
    			 }
    		 }
   
    	return password;
    	}
    	 
    	 }
