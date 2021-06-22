package com.yxr.tools;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class display
 */
public class opServlet extends HttpServlet {

	public opServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		goodsShow show = new goodsShow();

		// 获取数组对象
		List<Goods> list = new ArrayList<Goods>();

		// 获取查询的名称
		String s_name = request.getParameter("s_name");

		// 获取添加的数据
		//String add_n = request.getParameter("add_number");

		String add_name = request.getParameter("add_name");
		//String add_p = request.getParameter("add_price");
		
		String add_r=request.getParameter("add_reason");
		String add_c=request.getParameter("add_comebackornot");

		//String add_putaway = request.getParameter("add_putaway");
		// 获取修改的数据
		//String up_n = request.getParameter("up_number");

		String up_name = request.getParameter("up_name");
		
		String up_r=request.getParameter("up_reason");
		String up_c=request.getParameter("up_comebackornot");
		
		//String up_p = request.getParameter("up_price");

		//String up_putaway = request.getParameter("up_putaway");

		// 获取删除的商品编号
		String de_name = request.getParameter("de_name");

		// 查询数据
		if (s_name != null) {
			goodsSelect se = new goodsSelect();
			Goods goods = null;
			try {
				goods = se.select(s_name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(goods);
			s_name = "";
		} else {// 显示所有的数据
			list = show.getALL();
		}
		// 添加数据
//		if (add_name != null) {
////			int add_number = Integer.parseInt(add_n);
////			float add_price = Float.valueOf(add_p);
//			Goods goods = new Goods();
////			goods.setNumber(add_number);
//			goods.setName(add_name);
////			goods.setPrice(add_price);
//			goods.setComebackornot(add_c);
//			goods.setReason(add_r);
//
//			goodsAdd add = new goodsAdd();
//			try {
//				add.insert(goods);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			list = show.getALL();
//			//add_n = "";
//			add_name = "";
//			add_r="";
//			add_c="";
//			//add_p = "";
//			//add_putaway = "";
//		}
		// 修改数据
		if (up_name != null) {
			//int up_number = Integer.parseInt(up_n);
			//float up_price = Float.valueOf(up_p);
			Goods goods = new Goods();
			goodsUpdate update = new goodsUpdate();
			//goods.setNumber(up_number);
			goods.setName(up_name);
			goods.setReason(up_r);
			goods.setComebackornot(up_c);
			//goods.setPrice(up_price);
			//goods.setPutaway(up_putaway);

			try {
				update.update(goods);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list = show.getALL();
			//add_n = "";
			add_name = "";
			add_r="";
			add_c="";
			//add_p = "";
			//add_putaway = "";
		}
		// 删除数据
		if (de_name != null) {
			//int de_number = Integer.parseInt(de_n);
			goodsDelete delete = new goodsDelete();
			try {
				delete.delete(de_name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list = show.getALL();
			de_name = "";
		}
		// 传递数组到jsp页面
		request.setAttribute("goodslist", list);
		request.getRequestDispatcher("Commodity.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
