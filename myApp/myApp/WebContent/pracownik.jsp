<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:useBean id="firma" class="model2.Firma" scope="application"></jsp:useBean>
<jsp:useBean id="prac" class="model2.Osoba" scope="request" ></jsp:useBean>
<%
	try{
		int pid = Integer.parseInt(
				request.getParameter("id"));
		int jid = Integer.parseInt(request.getParameter("jid"));
		
		
		model2.Osoba o = firma.getJednostki().get(jid).getPracownicy().get(pid);
		prac.setImie(o.getImie());
		prac.setNazwisko(o.getNazwisko());
		prac.setFoto(o.getFoto());
		prac.setStanowisko(o.getStanowisko());
	}
	catch (NumberFormatException e){
		//Obsługa złych parametrów id, jid
	}
%>
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<td>
	<img src="${prac.foto}" height="100"/></td>
	
	<td><table>
		<tr><td>${prac.imie}</td></tr>
		<tr><td>${prac.nazwisko}</td></tr>
		<tr><td>${prac.stanowisko.nazwa}</td></tr>
		</table>
	</td>
</tr>
</table>


</body>
</html>