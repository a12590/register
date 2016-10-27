package com.itheima.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String encoding = "UTF-8";
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		
		request.getSession().removeAttribute("user");
//		request.getSession().invalidate();
		response.getWriter().write("注销成功。2秒后转向主页。");
		response.setHeader("Refresh", "2;URL="+request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
