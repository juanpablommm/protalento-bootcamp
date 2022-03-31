<%@page import="ar.com.educacionit.domain.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	/*objetos implicitos que tiene las jsp*/
	Users users = (Users) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="description" content="bootcamp protalento,
    mercado digital">
    <meta  name="keywords" content="jsp, protalento, bootcamp, educacion it">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
<title>Insert title here</title>
</head>
<body>
    <main>
        <hgroup>
            <h1>Username: <%=users.getUsername()%></h1>
            <h2>Nombre: <%=users.getSocio().getNombre()%></h2>
            <h3>Apellido: <%=users.getSocio().getApellido()%></h3>
            
            <a href="<%=request.getContextPath()%>/BuscarProductosServlet">Ver listado</a>
        </hgroup>
    </main>

</body>
</html>