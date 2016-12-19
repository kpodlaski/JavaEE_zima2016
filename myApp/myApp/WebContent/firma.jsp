<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="model2.Jednostka, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="db" class="jdbc.DBConnector" scope="application"/>
<title>Strona Firmowa </title>
</head>
<body>
<h1>${firma.nazwa}</h1>
Jednostki firmy:<br/>
<% 
	List <Jednostka> jednostki = db.getAllJednostki();
	for (int id =0; id< jednostki.size(); id++)
	{
		Jednostka jedn = jednostki.get(id);
		out.println( " <a href='jednostka.jsp?id="+id+"'>"+jedn.getNazwa()+"</a>"    );
	}
%>
</body>
</html>