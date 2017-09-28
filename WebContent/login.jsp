<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Iterator"%>  
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%  
request.setCharacterEncoding("UTF-8");  
%>  
<%  
List<String> info=(List<String>)request.getAttribute("info");  
if(info!=null){  
    Iterator<String> iter=info.iterator();  
    while(iter.hasNext()){  
%>  
<%=iter.next()%> 
<%   
}  
}  
%>  
 
	<form action= "showuser" method="post">
	<input type="hidden" name="oprate" value ="login">
			<input type='text' name="username" placeholder="请输入用户名"><br/>
			<input type='password' name="password" placeholder="密码"><br/>
	
			<input type="submit" value="登录">
			<a href = "register.jsp">添加用户</a>
			
	</form>

</body>
</html>