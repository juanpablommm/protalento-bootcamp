<!DOCTYPE html>
<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<html lang="es">
<head>
	<meta name="description" content="bootcamp protalento, mercado digital">
	<meta name="keywords" content="jsp, protalento, bootcamp, educacion it">
	<title>Login</title>
	<!-- importo mi jsp externa la cual contiene todas la hojas de stylos css -->
	<jsp:include page="styles.jsp"></jsp:include>
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
				<div class="col-6">
					<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Usser</label>
							<input type="text" name="<%=ViewsKeysEnum.USERNAME.getName()%>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
							<div id="emailHelp" class="form-text">Bienbeido al sistema ingresa tu usuario...</div>
						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" class="form-label">Password</label>
							<input type="password" name="<%=ViewsKeysEnum.PASSWORD.getName()%>" class="form-control" id="exampleInputPassword1">
						</div>
						<div class="mb-3 form-check">
							<input type="checkbox" class="form-check-input" id="exampleCheck1">
							<label class="form-check-label" for="exampleCheck1">Check me out</label>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</section>
	</main>

	<!-- importo mi jsp que contien la parte javascrip de bootrat -->
	<jsp:include page="js/scripts.jsp"></jsp:include>
</body>
</html>