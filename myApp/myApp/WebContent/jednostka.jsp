<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model2.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="firma" class="model2.Firma" scope="application"></jsp:useBean>
<jsp:useBean id="jedn" class="model2.Jednostka" scope="request" ></jsp:useBean>
<jsp:setProperty property="*" name="jedn"/>
<%
	if (jedn.getId()<firma.getJednostki().size()){
		jedn.setPracownicy(firma.getJednostki().get(jedn.getId()).getPracownicy());
		jedn.setNazwa(firma.getJednostki().get(jedn.getId()).getNazwa());
	}
%>
<title>Insert title here ${jedn.nazwa}</title>
</head>
<body>
${jedn.id}
</body>
</html>