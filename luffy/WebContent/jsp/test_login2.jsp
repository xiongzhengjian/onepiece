<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>login test</title>
	<%String path = request.getContextPath(); //path="/luffy"
	  //  basePath="http://localhost:8080/luffy/"
	  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<base href="<%=basePath%>">
</head>
<body>
	<form action="./login.action" method="post">
		<table border="1">
			<tr>
				<td>用户名：</td>
				<td><input id="username" type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input id="username" type="text" name="username"></td>
			</tr>
			<tr>				
				<td><input id="remember" type="checkbox" name="remember" value="false"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录"></td>
			</tr>
			
		</table>
	</form>
</body>
</html>