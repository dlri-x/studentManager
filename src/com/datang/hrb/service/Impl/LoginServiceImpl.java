package com.datang.hrb.service.Impl;

import com.datang.hrb.dao.UserDao;
import com.datang.hrb.service.LoginService;
import com.datang.hrb.vo.User;

public class LoginServiceImpl implements LoginService {

	@Override
	public String login(User user) {//根据用户名获取用户数据和数据库打交道放在dao层
	UserDao userDao=new UserDao();
	String password=userDao.getUserByUseername(user.getUsername());
	if(password.equals(user.getPassword())) {
		return"login.jsp";
	}else { 
	
		return "login_fail.jsp";
	}

	

}
}