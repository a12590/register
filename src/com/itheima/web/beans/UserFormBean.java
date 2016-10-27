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
	//错误消息。key：哪个字段；value：消息
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
	//数据验证：如果有不正确的情况，向errors中添加消息提示
	public boolean validate(){
		//验证
		if("".equals(username)){
			errors.put("username", "请输入用户名");
		}else if(!username.matches("[a-zA-Z]{3,8}")){
			errors.put("username", "用户名必须由3~8位字母组成");
		}
		
		if("".equals(password)){
			errors.put("password", "请输入密码");
		}else if(!password.matches("\\d{3,8}")){
			errors.put("password", "密码必须由3~8位数字组成");
		}
		
		if(!repassword.equals(password)){
			errors.put("repassword", "两次密码不一致");
		}
		
		if("".equals(email)){
			errors.put("email", "请输入邮箱");
		}else if(!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")){
			errors.put("email", "请输入正确的邮箱");
		}
		if("".equals(birthday)){
			errors.put("birthday", "请输入日期");
		}else{
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
//				df.parse(birthday);
				new DateLocaleConverter().convert(birthday);
			} catch (Exception e) {
				errors.put("birthday", "日期必须是yyyy-MM-dd的格式");
			}
			
		}
		return errors.isEmpty();
	}
	
}
