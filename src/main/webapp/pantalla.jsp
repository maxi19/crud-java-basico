<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="monolitico.com.domain.Persona"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <% Persona p = (Persona) request.getAttribute("mensaje"); %>
       
 	
 		<p><%=p.getNombre()%></p>


</body>
</html>