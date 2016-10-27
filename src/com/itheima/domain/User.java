package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private String username;//必须有，唯一
	private String password;//必须有
	private String email;//必须有
	private Date birthday;//必须有yyyy-MM-dd
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
