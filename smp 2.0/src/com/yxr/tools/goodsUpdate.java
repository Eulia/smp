package com.yxr.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ��ɶ����ݿ����ɾ�Ĳ����
 */
public class goodsUpdate {
	// �޸���Ʒ��Ϣ
	public boolean update(Goods goods) throws SQLException {
		PreparedStatement ps;
		int rs = 0;
		Connect db = new Connect();
		Connection conn = null;
		// ������ݵ�����
		conn = db.getConn();
		try {
			ps = (PreparedStatement) conn
					.prepareStatement("update smp set name=?,reason=?,comebackornot=? where name=?");
//			ps.setInt(1, goods.getNumber());
			ps.setString(1, goods.getName());
			ps.setString(2, goods.getReason());
			ps.setString(3, goods.getComebackornot());
			ps.setString(4, goods.getName());
//			ps.setFloat(3, goods.getPrice());
//			ps.setString(4, goods.getPutaway());
//			ps.setInt(5, goods.getNumber());
			Statement stmt = conn.createStatement();
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
