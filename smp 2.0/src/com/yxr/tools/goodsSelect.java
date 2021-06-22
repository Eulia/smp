package com.yxr.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ��ɶ����ݿ����ɾ�Ĳ����
 */
public class goodsSelect {
	// ������Ʒ
	public Goods select(String name) throws SQLException {
		PreparedStatement ps;
		ResultSet rs = null;
		Connect db = new Connect();
		Connection conn = null;
		// ������ݵ�����
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
