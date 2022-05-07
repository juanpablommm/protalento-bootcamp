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
			<jsp:include page="./components/tableArticulosResultados.jsp"/>
			
		</section>
	</main>

	<!-- importo mi jsp que contien la parte javascrip de bootrat -->
	<jsp:include page="js/scripts.jsp"></jsp:include>
</body>
</html>