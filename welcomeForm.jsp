<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome JSP page</title>
</head>
<body>

<%
		if(session.getAttribute("email1")==null)
		{
			response.sendRedirect("login.jsp");
		}

%>
welcome to jsp page

	<form action="logout">
<input type="submit" value="Logout"> 
	</form>
</body>
</html>