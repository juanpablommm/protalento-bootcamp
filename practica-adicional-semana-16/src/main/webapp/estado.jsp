<!DOCTYPE html>
<%@page import="com.educacionit.service.enums.MensajesEnums"%>
<%@page import="com.educacionit.service.enums.ViewsEnums"%>
<%@page import="com.educacionit.domain.Carrousel"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="utf-8">
<meta name="description"
	content="bootcamp educacion it, java developer practica semana 16">
<meta name="keywprds" content="java, html, jsp, servlets">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- rediriciono al index de la aplicacion -->
<meta http-equiv="Refresh" content="7; <%=request.getContextPath() + ViewsEnums.HOME.getView()%>"/><!-- redirigir al listado -->
<title>Successful</title>
<link rel="stylesheet" href="./styles/bootstrap.min.css">
</head>
<body>
<!-- obtengo el mensaje que venga desdes los servlets -->
<%String mensage = (String) request.getAttribute(MensajesEnums.class.getSimpleName()); %>
	<header class="container-fluid">
			<h1 class="col"><%=mensage%></h1>
	</header>
	<main class="container-fluid">
		<header class="row">
			<p>Se le redicionara al listado de registros...</p>
		</header>
	</main>
</body>
</html>