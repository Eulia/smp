package com.yxr.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 完成对数据库的增删改查操作
 */
public class goodsDelete {
	// 删除数据
	public boolean delete(String name) throws SQLException {
		PreparedStatement ps;
		int rs = 0;
		Connect db = new Connect();
		Connection conn = null;
		// 获得数据的连接
		conn = db.getConn();
		try {
			ps = (PreparedStatement) conn.prepareStatement("delete from smp where name=? ");
			ps.setString(1, name);
			//Statement stmt = conn.createStatement();
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rs > 0) {
			return true;
		}
		return false;
	}
}
