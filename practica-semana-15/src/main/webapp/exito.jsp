<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Exito</title>
</head>
<body>
	<main>
		<h1>Registro Exitoso</h1>
		<p>Se ha realizado el regsitro de manera exitossa puedes consultar el listado y corroborarlo</p>
		<form action="<%=request.getContextPath()%>/listado.jsp">
			<input type="submit" name="listado" value="Listado">
		</form>
	</main>

</body>
</html>