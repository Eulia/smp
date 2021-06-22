package com.yxr.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class goodsShow {
	public List<Goods> getALL() {
		PreparedStatement ps;
		ResultSet rs = null;
		Connect db = new Connect();
		Connection conn = null;
		conn = db.getConn();
		List<Goods> list = new ArrayList<Goods>();
		try {
			ps = conn.prepareStatement("select * from smp ");
			Statement stmt = conn.createStatement();
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("添加信息成功");
				Goods goods = new Goods();
				//goods.setNumber(rs.getInt("number"));
				goods.setName(rs.getString("name"));
				goods.setReason(rs.getString("reason"));
				goods.setComebackornot(rs.getString("comebackornot"));
				//goods.setPrice(rs.getFloat("price"));
				//goods.setPutaway(rs.getString("putaway"));
				list.add(goods);
			}
			conn.close();

		} catch (SQLException e) {
			System.out.println("未查询到学生信息");
			e.printStackTrace();
		}
		return list;
	}

}
