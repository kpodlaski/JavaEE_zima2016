<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,model2.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:useBean id="firma" class="model2.Firma" scope="application"></jsp:useBean>
<jsp:useBean id="jedn" class="model2.Jednostka" scope="request" ></jsp:useBean>

<jsp:setProperty property="*" name="jedn"/>
<%
	if (jedn.getId()<firma.getJednostki().size()){
		jedn.setPracownicy(firma.getJednostki().get(jedn.getId()).getPracownicy());
		jedn.setNazwa(firma.getJednostki().get(jedn.getId()).getNazwa());
	}
%>
<title>Jednostka ${jedn.nazwa}</title>
</head>
<body>
<h1>${jedn.nazwa}</h1>
Paracownicy:<br/>
<% 
	for (int pid =0; pid< jedn.getPracownicy().size(); pid++)
	{
		Osoba o = jedn.getPracownicy().get(pid);
		out.println( " <a href='pracownik.jsp?id="+pid+"&jid="+jedn.getId()+"'>"+o.getImie()+" "+o.getNazwisko()+"</a>"    );
	}
%>
<hr/>
<c:set var="pid" value="0" />
<c:forEach var="osoba" items="${jedn.pracownicy}"> 
	${osoba.imie} ${osoba.nazwisko} <br/>
	<a href='pracownik.jsp?id=${pid=pid+1}&jid=${jedn.id}'>${osoba.imie} ${osoba.nazwisko}</a>
	<br/>
</c:forEach>
</body>
</html>