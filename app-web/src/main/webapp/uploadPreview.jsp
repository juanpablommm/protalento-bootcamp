<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
		<section class="container-fluid">
			<h1>Preview de Archivos a Procesar</h1>
			<!-- importo mi tabla de articulos -->
			<jsp:include page="./components/tableArticulos.jsp"/>
			<div class="row">
				<div class="col">
					<a class="btn btn-outline-success me-2"
						href="<%=request.getContextPath()%>/controllers/CargarProductoServlet"
						role="button">Guardar</a>
				</div>
			</div>
		</section>
	</main>

	<!-- importo mi jsp que contien la parte javascrip de bootrat -->
	<jsp:include page="js/scripts.jsp"></jsp:include>
</body>
</html>