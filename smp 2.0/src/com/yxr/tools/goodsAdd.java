package com.yxr.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ��ɶ����ݿ����ɾ�Ĳ����
 */
public class goodsAdd {
	// Ϊ��Ʒ���������
	public boolean insert(Goods goods) throws SQLException {
		PreparedStatement ps;
		Connect db = new Connect();
		Connection conn = null;
		int rs = 0;
		// ������ݵ�����
		conn = db.getConn();
		try {
			ps = (PreparedStatement) conn
					.prepareStatement("insert into smp(name,reason,comebackornot) values(?,?,?); ");
			//ps.setInt(1, goods.getNumber());
			
			ps.setString(1, goods.getName());
			ps.setString(2, goods.getReason());
			ps.setString(3, goods.getComebackornot());
			//ps.setFloat(3, goods.getPrice());
			//ps.setString(4, goods.getPutaway());
			Statement stmt = conn.createStatement();
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rs > 0) {
			return true;
		} else
			return false;
	}

}
