<!DOCTYPE html>
<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<html lang="es">
<head>
	<meta name="description" content="bootcamp protalento, mercado digital">
	<meta name="keywords" content="jsp, protalento, bootcamp, educacion it">
	<title>Login</title>
	<!-- importo mi jsp externa la cual contiene todas la hojas de stylos css -->
	<jsp:include page="styles.jsp"></jsp:include>
	
	<!--funcion javascrip para validar el action
	de un formulario dependiendo del boton presionado -->
	<script type="text/javascript">
	function send(){
		/*obtenemos el primer formulario del html*/
		const formulario = document.forms[0];

		const objectLogin = {
			username : document.getElementById("user").value,
			password : document.getElementById("password").value
		};
		
		formulario.method = "post";
		/*objecto nativo de javascript JSON
		metodos:
			
		JSON.parse(obj) : obj de javascript
		JSON.stringify(obj): : objecto JSON*/
// 		alert(JSON.stringify(objectLogin));

		/*traigo mi intput que estaba escondido en el html
		por medio del atributo hidden y le asigno como valor
		el objecto JSON*/
		document.getElementById("data").value = JSON.stringify(objectLogin);
		//llamo al metodo submit
		formulario.submit();
	}
</script>
</head>
<body>

	<!-- importo mi jps externa que contine el nav -->
	<jsp:include page="navbar.jsp"></jsp:include>

	<main>
		<!-- section para alertas para mostrar errores -->
		<jsp:include page="alertas.jsp"></jsp:include>

		<!-- section principal -->
		<section class="container">
			<div class="row">
				<div class="col-12 mb-3">
					<h1 class="mb-3">Login</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8 col-md-8 col-lg-8 col-xl-8 col-xxl-8" id="bloqueLogin">
					<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
						<div class="mb-3">
							<!--inpput escondido para enviar el object JSON-->
							<input type="hidden" name="data" id="data">
							<label for="exampleInputEmail1" class="form-label">Usser</label>
							<input type="text" class="form-control" id="user" aria-describedby="emailHelp">
							<div id="emailHelp" class="form-text">Bienvenido al sistema ingresa su usuario...</div>
						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" class="form-label">Password</label>
							<input type="password" class="form-control" id="password">
						</div>
						<button type="button" class="btn btn-outline-success me-2" onclick="send()">Enviar</button>
					</form>
				</div>
				<div class="col" id="bloqueLoginImg">
					<figure>
						<img alt="" src="<%=request.getContextPath()%>/img/ImagenLogin.gif" width="70%">
						<figcaption>B. Java Developer</figcaption>
					</figure>
				</div>
			</div>
		</section>
	</main>

	<!-- importo mi jsp que contien la parte javascrip de bootrat -->
	<jsp:include page="js/scripts.jsp"></jsp:include>
</body>
</html>