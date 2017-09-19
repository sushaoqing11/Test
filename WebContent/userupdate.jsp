<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form >
		
			<input type='text'  value="${user.id}">id<br/>
			<input type='text'  value="${user.name}">姓名<br/>
			<input type='text' value="${user.age}">年龄<br/>
	</form>
	
	<br>
	<br>
	请输入修改信息
	<br>

	<form action= "showuser" method="post">
	<input type="hidden" name="oprate" value ="update">
			<input type='text' name="id" value="${user.id}"><br/>
			  <input type='text' name="name" placeholder="请修改姓名"><br/>
			  <input type='text' name="age" placeholder="请修改年龄"><br/>
	
			<input type="submit" value="确认修改">
	

	</form>

</body>
</html>