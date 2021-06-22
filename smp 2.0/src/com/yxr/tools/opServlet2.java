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
public class opServlet2 extends HttpServlet {

	public opServlet2() {
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
		// 获取添加的数据
		//String add_n = request.getParameter("add_number");

		String add_name = request.getParameter("add_name");
		//String add_p = request.getParameter("add_price");
		
		String add_r=request.getParameter("add_reason");
		String add_c=request.getParameter("add_comebackornot");

		//String add_putaway = request.getParameter("add_putaway");
		

		
		// 添加数据
		if (add_name != null) {
//			int add_number = Integer.parseInt(add_n);
//			float add_price = Float.valueOf(add_p);
			Goods goods = new Goods();
//			goods.setNumber(add_number);
			goods.setName(add_name);
//			goods.setPrice(add_price);
			goods.setComebackornot(add_c);
			goods.setReason(add_r);

			goodsAdd add = new goodsAdd();
			try {
				add.insert(goods);
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
		request.setAttribute("goodslist", list);
		request.getRequestDispatcher("666绿码页.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
