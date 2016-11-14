<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="model.User"> </jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<button name="name" text="text">
Coś tam coś tam
<br/>
Hello ${user.name}
<hr/>
</button>
<table>
<%
	
	for(int i=0;i<10;i++){
		out.append("<tr>");
		for(int j=0;j<10;j++){
			out.append("<td>");
			out.append(""+( i*j ));
			out.append("</td>");
		}
		out.append("</tr>");
		
		out.append(user.getName());
	}
%>
</table>
</body>
</html>