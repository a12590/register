<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/calendar.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar.js"></script>

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/servlet/RegistServlet" method="post" enctype="application/x-www-form-urlencoded">
    	<!-- 
    	约定优于编码：遵守好的约定，会使代码编写更加高效
    	目前约定：表单的字段名和JavaBean的属性名保持了一致
    	 -->
    	<table border="1" width="738">
    		<tr>
    			<td>用户名：</td>
    			<td>
    				<input type="text" name="username" value="${formBean.username}"/>${formBean.errors.username}
    			</td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td>
    				<input type="password" name="password" value=""/>${formBean.errors.password}
    			</td>
    		</tr>
    		<tr>
    			<td>确认密码：</td>
    			<td>
    				<input type="password" name="repassword"/>${formBean.errors.repassword}
    			</td>
    		</tr>
    		<tr>
    			<td>邮箱：</td>
    			<td>
    				<input type="text" name="email" value="${formBean.email}"/>${formBean.errors.email}
    			</td>
    		</tr>
    		<tr>
    			<td>生日yyyy-MM-dd：</td>
    			<td>
    				<input type="text" name="birthday" value="${formBean.birthday}" readonly="readonly" onClick="return showCalendar('birthday', 'y-mm-dd');"/>${formBean.errors.birthday}
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="注册"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
