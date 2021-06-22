package com.yxr.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 完成对数据库的增删改查操作
 */
public class goodsSelect {
	// 查找商品
	public Goods select(String name) throws SQLException {
		PreparedStatement ps;
		ResultSet rs = null;
		Connect db = new Connect();
		Connection conn = null;
		// 获得数据的连接
		conn = db.getConn();

		Goods goods = new Goods();
		try {
			ps = (PreparedStatement) conn
					.prepareStatement("Select name,reason,comebackornot from smp where name=?");
			ps.setString(1, name);
			//Statement stmt = conn.createStatement();
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rs.next()) {
			//goods.setNumber(rs.getInt("number"));
			goods.setName(rs.getString("name"));
			goods.setReason(rs.getString("reason"));
			goods.setComebackornot(rs.getString("comebackornot"));
			//goods.setPrice(rs.getFloat("price"));
			//goods.setPutaway(rs.getString("putaway"));
			return goods;
		}
		return null;
	}
}
