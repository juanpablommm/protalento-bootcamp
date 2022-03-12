<html>
	<head>
		<title>Clase 36 -Inicio java web</title>
	</head>
	<body>
		<h1>Clase 36</h1>
		<!-- creo formulario -->
		<form action="<%=request.getContextPath()%>/ListadoServlet"
		method="POST">
		<!-- POR QUE METODO VAMOS A GENERAR LA PETICION 
		POR POST SE PASAN LOS PARAMETROS POR FORMULARIO, PSANA DE UNA MAERA OCUALTA
		Y POR GET LOS PARAMETROS VIAJAN POR LA URL-->
		
			<!-- con un boton adentro -->
			<input type="submit" value="Pedir listado por post"/>
		</form>
		
		<form action="<%=request.getContextPath()%>/ListadoServlet" method="GET">
			
			<input type="submit" value="Pedir listado por get" /> 
		</form>
	</body>
</html>