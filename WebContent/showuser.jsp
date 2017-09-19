<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="1000px"cellpadding="0px"cellpadding = "0px" border="1px" style="border:1px solid gray;border-collspase:collspase;">
  <tr>
  <th> id</th>
  <th>姓名</th>
  <th>年龄</th>
  <th>操作</th>
  
  
  </tr>
<c:forEach items="${userlist}" var="user">
          <tr> 
                    <td>${user.id} </td> 
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td><a href="showuser?oprate=toupdate&id=${user.id}">修改</a> | 
                    <a href="showuser?oprate=delete&id=${user.id}">删除</a></td> 

          </tr> 
</c:forEach>
		<tr>
			<td colspan="6" >
			<a href = "showuser?pagenumber=1">首页</a>
			<a href = "showuser?pagenumber=${pagenumber-1}"> 上一页</a>
			<a href = "showuser?pagenumber=${pagenumber+1}">下一页</a>
			<a href = "showuser?pagenumber=${pagecount}">尾页</a>
			<a href = "adduser.jsp">添加用户</a>
			</td>
		</tr>
</table>
</body>
</html>