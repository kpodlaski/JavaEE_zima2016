<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model2.Jednostka"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="firma" class="model2.Firma" scope="application"/>
<title>Strona Firmowa ${firma.nazwa}</title>
</head>
<body>
<h1>${firma.nazwa}</h1>
Jednostki firmy:<br/>
<% 
	for (int id =0; id< firma.getJednostki().size(); id++)
	{
		Jednostka jedn = firma.getJednostki().get(id);
		out.println( " <a href='jednostka.jsp?id="+id+"'>"+jedn.getNazwa()+"</a>"    );
	}
%>
</body>
</html>