package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private String username;//�����У�Ψһ
	private String password;//������
	private String email;//������
	private Date birthday;//������yyyy-MM-dd
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
