package com.datang.hrb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
private static Connection conn=null;//在此类定义一个静态私有连接变量
public static Connection getConnection() {//util类对外暴露的获连接方法
	if(conn==null) {//第一次连接conn为空，创建一个新连接
		//创建数据库连接
		System.out.println("new connection");
		try {//加载光驱，8.0jar包提供了最新的驱动类名，不加载光驱无法创建新连接
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取连接connection对象，使用drivermanager类的静态方法getconnection获取数据库连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentManager?useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC", "root","godislgirl");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return conn;
}
public static void main(String[] args) {
	System.out.println(ConnectionUtil.getConnection());
}
}
