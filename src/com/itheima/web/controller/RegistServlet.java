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
//�����ص㡣���ע��
public class RegistServlet extends HttpServlet {
	private BusinessService s = new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String encoding = "UTF-8";
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		
		//��ȡ�����ݣ���װ��JavaBean�С�����FormBean���ص����Ժͱ��ֶ���ȫһ�¡��Ҷ���String���͡���װ������Ϣ��
		UserFormBean formBean = FillBeanUtil.fillBean(request, UserFormBean.class);
		//������֤������������֤��ʵ�ʿ����У��ͻ���+����������֤��
		if(!formBean.validate()){
			//��ͨ�����������ݣ���Ϣ��ʾ
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		//���ģ�ͣ�formBean---->JavaBean
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
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);//ע������ת����
		try {
			BeanUtils.copyProperties(user, formBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//ͨ��������Service��������
		try {
			s.regist(user);
			response.getWriter().write("����ɹ���2���ת����ҳ");
			response.setHeader("Refresh", "2;URL="+request.getContextPath());
		} catch (UserExistException e) {
			//���ݻ��Ժ���ʾ
			formBean.getErrors().put("username", "�û����Ѿ�������");
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
