<html>
	<head>
		<title>Clase 36 -Inicio java web</title>
	</head>
	<body>
		<h1>Clase 36</h1>
		<h2>subtitulo</h2>
		<ul>
			<li>1</li>
			<li>2</li>
			<li>3</li>
			<li>4</li>
		</ul>
		
		<%
// 			es codigo java que se compila
// 			y se muestra como html
			for(int i = 0; i < 4; i++){
			    out.print("i vale: " + i + "<br>");
			}

		%>
		<!-- creo formulario -->
		<form action="<%=request.getContextPath()%>/listado"
		method="POST">
		<!-- POR QUE METODO VAMOS A GENERAR LA PETICION 
		POR POST SE PASAN LOS PARAMETROS POR FORMULARIO, PSANA DE UNA MAERA OCUALTA
		Y POR GET LOS PARAMETROS VIAJAN POR LA URL-->
		
			<!-- con un boton adentro -->
			<input type="submit" value="Pedir listado por post"/>
		</form>
		
		<form action="<%=request.getContextPath()%>/listado" method="GET">
			
			<input type="submit" value="Pedir listado por get" /> 
		</form>
	</body>
</html>