<!DOCTYPE html>
<%@page import="com.educacionit.service.enums.MensajesEnums"%>
<%@page import="com.educacionit.service.enums.ViewsEnums"%>
<%@page import="com.educacionit.domain.Carrousel"%>
<%@page import="java.util.List"%>
<html>
<head>

<jsp:include page="metasAndLinks.jsp"/>
<!-- rediriciono al index de la aplicacion -->
<meta http-equiv="Refresh" content="7; <%=request.getContextPath() + ViewsEnums.HOME.getView()%>"/><!-- redirigir al listado -->
<title>Estatus</title>
</head>
<body>
<!-- obtengo el mensaje que venga desdes los servlets -->
<%String mensage = (String) request.getAttribute(MensajesEnums.class.getSimpleName()); %>
	<header class="container-fluid">
			<h1 class="col"><%=mensage%></h1>
	</header>
	<main class="container-fluid">
		<header class="row">
			<p class="texto">Se le redicionara al listado de registros...</p>
		</header>
	</main>
</body>
<jsp:include page="footer.jsp"/>
</html>