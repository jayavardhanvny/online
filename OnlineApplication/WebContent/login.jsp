<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.vinay.servlets.validate"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1 align="Center">Login Details</h1><br>
	<form action="validate.html" method="post">
		Username: <input type="username" name="username"/><br>
		Password: <input type="password" name="password"/><br>
		<input type="submit" value="login"/>
	</form>
</body>
</html>