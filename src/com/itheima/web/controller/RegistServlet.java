package com.itheima.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.itheima.domain.User;
import com.itheima.exception.UserExistException;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;
import com.itheima.util.FillBeanUtil;
import com.itheima.web.beans.UserFormBean;
//编码重点。完成注册
public class RegistServlet extends HttpServlet {
	private BusinessService s = new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String encoding = "UTF-8";
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		
		//获取表单数据，封装到JavaBean中。引入FormBean：特点属性和表单字段完全一致。且都是String类型。封装错误消息。
		UserFormBean formBean = FillBeanUtil.fillBean(request, UserFormBean.class);
		//数据验证：服务器端验证。实际开发中：客户端+服务器端验证。
		if(!formBean.validate()){
			//不通过：回显数据，消息提示
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		//填充模型：formBean---->JavaBean
		User user = new User();
//		user.setUsername(formBean.getUsername());
//		user.setPassword(formBean.getPassword());
//		user.setEmail(formBean.getEmail());
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			user.setBirthday(df.parse(formBean.getBirthday()));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);//注册类型转换器
		try {
			BeanUtils.copyProperties(user, formBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//通过：调用Service保存数据
		try {
			s.regist(user);
			response.getWriter().write("保存成功！2秒后转向主页");
			response.setHeader("Refresh", "2;URL="+request.getContextPath());
		} catch (UserExistException e) {
			//数据回显和提示
			formBean.getErrors().put("username", "用户名已经存在了");
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
