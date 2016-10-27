package com.itheima.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {
	private BusinessService s = new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String encoding = "UTF-8";
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = s.login(username, password);
		if(user==null){
			//������û���������
			response.getWriter().write("������û��������롣2���ת���¼ҳ�档");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
			return;
		}
		
		//��¼�ɹ�
		request.getSession().setAttribute("user", user);
		response.getWriter().write("��¼�ɹ���2���ת����ҳ��");
		response.setHeader("Refresh", "2;URL="+request.getContextPath());
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
