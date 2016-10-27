package com.itheima.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.util.Dom4JUtil;

public class UserDaoXmlImpl implements UserDao {

	public void save(User user) {
		try {
			Document document = Dom4JUtil.getDocument();
			Element root = document.getRootElement();
			root.addElement("user")
				.addAttribute("username", user.getUsername())
				.addAttribute("password", user.getPassword())
				.addAttribute("email", user.getEmail())
				.addAttribute("birthday", user.getBirthday().toLocaleString());
			Dom4JUtil.write2xml(document);
		} catch (Exception e) {
			throw new RuntimeException(e);//异常转义和异常转义链
		}
	}

	public User findUser(String username) {
		try {
			Document document = Dom4JUtil.getDocument();
			Node node = document.selectSingleNode("//user[@username='"+username+"']");
			if(node==null)
				return null;
			User user = new User();
			user.setUsername(node.valueOf("@username"));
			user.setPassword(node.valueOf("@password"));
			user.setEmail(node.valueOf("@email"));
			
			String sbirthday = node.valueOf("@birthday");
			Date birthday = null;
			if(sbirthday!=null&&!sbirthday.equals("")){
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				birthday = df.parse(sbirthday);
			}
			user.setBirthday(birthday);
			
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public User findUser(String username, String password) {
		try {
			Document document = Dom4JUtil.getDocument();
			Node node = document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(node==null)
				return null;
			User user = new User();
			user.setUsername(node.valueOf("@username"));
			user.setPassword(node.valueOf("@password"));
			user.setEmail(node.valueOf("@email"));
			
			String sbirthday = node.valueOf("@birthday");
			Date birthday = null;
			if(sbirthday!=null&&!sbirthday.equals("")){
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				birthday = df.parse(sbirthday);
			}
			user.setBirthday(birthday);
			
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
