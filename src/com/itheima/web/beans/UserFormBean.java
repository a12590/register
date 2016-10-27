package com.itheima.web.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class UserFormBean {
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String birthday;
	//������Ϣ��key���ĸ��ֶΣ�value����Ϣ
	private Map<String, String> errors = new HashMap<String, String>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	//������֤������в���ȷ���������errors�������Ϣ��ʾ
	public boolean validate(){
		//��֤
		if("".equals(username)){
			errors.put("username", "�������û���");
		}else if(!username.matches("[a-zA-Z]{3,8}")){
			errors.put("username", "�û���������3~8λ��ĸ���");
		}
		
		if("".equals(password)){
			errors.put("password", "����������");
		}else if(!password.matches("\\d{3,8}")){
			errors.put("password", "���������3~8λ�������");
		}
		
		if(!repassword.equals(password)){
			errors.put("repassword", "�������벻һ��");
		}
		
		if("".equals(email)){
			errors.put("email", "����������");
		}else if(!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")){
			errors.put("email", "��������ȷ������");
		}
		if("".equals(birthday)){
			errors.put("birthday", "����������");
		}else{
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
//				df.parse(birthday);
				new DateLocaleConverter().convert(birthday);
			} catch (Exception e) {
				errors.put("birthday", "���ڱ�����yyyy-MM-dd�ĸ�ʽ");
			}
			
		}
		return errors.isEmpty();
	}
	
}
