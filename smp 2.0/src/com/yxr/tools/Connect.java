package com.yxr.tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	private Connection conn = null;
	private String drivername = "com.mysql.jdbc.Driver"; // mysql driver
	private String URL = "jdbc:mysql://127.0.0.1:3306/suda?user=root&password=02278525&useUnicode=true&characterEncoding=UTF-8";

	public Connect() {
	}

	public Connection getConn() { // get database connection
		try {
			Class.forName(drivername).newInstance(); // 载入驱动器
			conn = DriverManager.getConnection(URL); // 连接到数据库
			System.out.println("成功连接到数据库");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接数据库失败，请检查");
		}
		return conn;
	}
}
