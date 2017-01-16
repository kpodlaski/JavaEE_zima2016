<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>
$(document).ready( function(){
	
	$("button").click(function(){
		window.location.href = "../newTel.html";
	});
	
}
		
		);
</script>
<title>Insert title here</title>
</head>
<body>
Widok jest Simple 
<hr/>
${basicText} ${user.name} ${user.tel}
<button>Add New Person</button>
</body>
</html>