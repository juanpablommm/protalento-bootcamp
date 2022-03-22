<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
</head>
<body style="background-image: url('./imagenes/fondos-web.webp')">
	
	
	<main>
		<form action="<%=request.getContextPath()%>/LoginServlet"
			method="POST">

			<div  align="left">
				<img src="./imagenes/logo.png" alt="Avatar" class="avatar"
					width="9%" height="9%">
			</div>

			<div class="formulario" class="container">

				<label for="nombre"><b>Nombre</b></label> <br> 
				<input type="text" placeholder="Enter Nombre" name="nombre" required>

				<br> <label for="apellido"><b>Apellido</b></label> <br> <input
					type="text" placeholder="Enter Apellido" name="apellido" required>

				<br> <label for="text"><b>Documento</b></label> <br> 
				<input type="number" placeholder="Enter Documento" name="documento" required> 
				<br> 
				
				<label for="edad"><b>Edad</b></label> <br>	
				<input type="number" placeholder="Enter Edad" name="edad" required>
				
				<br>
				<label for="text"><b>Ocupacion</b></label>
				<br>
				<select name="ocupacion" required>
					<option>Trabajador</option>
					<option>Estudiante</option>
					<option>Pensionado</option>
				</select>
				
				<br>
				<label for="txt"><b>Fecha de Nacimiento</b></label>
				<br>
				<input type="date"  name="fechaNacimiento" required>

				<br>
				<br>
				<button type="submit">Enviar</button>
			</div>
		</form>
	</main>

</body>
</html>

