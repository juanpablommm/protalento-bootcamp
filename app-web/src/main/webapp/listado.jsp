<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
 	<!-- quiero capturar el listado que envio el servlet
 	bajo el nombre que se definio "" -->
 
	 <%//Scriplet permite escribir codigo java
 	//dentro de la jsp tengo un objeto implicito(no tengo que instanciarlo)
 	//request
 
	 //primero lo cacturo, el metodo getAttribute me devulve lo que se 
	//  encio desde el servlet pero en un Object, por lo que toca que castearlo
 	List<Articulos> listadoArticulos = (List<Articulos>) request.getAttribute("LISTADO");
 	%>
 
	<%
		//recorrer el listado e ir dibujando el html
		for(Articulos articulos: listadoArticulos){
		    
	%>
		<!-- puedo poner html puro y usar el objeto articulo -->
		<p><%=articulos.getCodigo()%></p>
		
	<%
		}
	%>
<body>

</body>
</html>