<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="styles.jsp" />
<title>Cargar Archivo</title>
</head>
<body>

	<!-- importo mi jps externa que contine el nav -->
	<jsp:include page="navbar.jsp"></jsp:include>

	<main>
		<!-- section para alertas para mostrar errores -->
		<jsp:include page="alertas.jsp"></jsp:include>

		<!-- section principal -->
		<section class="container">
			<div class="row d-flex justify-content-center">
				<h1>Preview de Archivos a Procesar</h1>
				<%
				Collection<Articulos> articulos = (Collection<Articulos>) request.getAttribute(ViewsKeysEnum.UPLOAD_PREVIEW_KEY.getName());
				out.println(articulos);
				%>

			</div>
		</section>
	</main>

	<!-- importo mi jsp que contien la parte javascrip de bootrat -->
	<jsp:include page="js/scripts.jsp"></jsp:include>
</body>
</html>