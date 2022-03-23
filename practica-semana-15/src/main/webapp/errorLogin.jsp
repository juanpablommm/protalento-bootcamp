<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
    <main>
        <h1>Error en el registro de datos: </h1>
        <p><%=(String) request.getAttribute("Mensaje") %></p>
        <hr>
        <form action="<%=request.getContextPath()%>/listado.jsp">
        	<input type="submit" name="listado" value="Listado">
        </form>
        <br>
        <form action="<%=request.getContextPath()%>/index.jsp">
            <input type="submit" name="index" value="Registro">
        </form>
    </main>

</body>
</html>