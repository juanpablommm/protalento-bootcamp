<!DOCTYPE html>
<%@page import="com.educacionit.dao.PersonaDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.educacionit.dao.PersonaDaoImpl"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.educacionit.domain.Persona"%>
<%@page import="java.util.Collection"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Listado</title>
</head>
<body>

	<main>
		<h1>Registros</h1>
		<form action="./">
			<input type="submit" name="back" value="Regresar">
		</form>
		<hr>

		<table border="1" width="900">
			<tr>
				<td><label><b>NOMBRE</b></label></td>
				<td><label><b>APELLIDO</b></label></td>
				<td><label><b>DOCUMENTO</b></label></td>
				<td><label><b>EDAD</b></label></td>
				<td><label><b>FECHA DE NACIMIENTO</b></label></td>
				<td><label><b>OCUPACION</b></label></td>
			</tr>
			
<!-- 			bloque java para obeneter cada persona de la lista registrada  -->
<!-- 			en la db -->
			<%
			PersonaDao personaDao = new PersonaDaoImpl();
			List<Persona> listaPersonas = personaDao.selectFrom();
			for (Persona persona : listaPersonas) {
			%>
			<tr>
				<td><label><%=persona.getNombre()%></label></td>
				<td><label><%=persona.getApellido()%></label></td>
				<td><label><%=persona.getDocumento()%></label></td>
				<td><label><%=persona.getEdad()%></label></td>
				<td><label><%=persona.getFechaNacimiento()%></label></td>
				<td><label><%=persona.getOcupacion()%></label></td>
			</tr>
			<%
			}
			%>
		</table>
	</main>
</body>
</html>