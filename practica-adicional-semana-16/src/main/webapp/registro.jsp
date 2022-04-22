<!DOCTYPE html>
<%@page import="com.educacionit.service.enums.ViewsEnums"%>
<%@page import="com.educacionit.domain.Carrousel"%>
<%@page import="java.util.List"%>
<html>
<head>
	<jsp:include page="metasAndLinks.jsp"/>
	<title>Registrar</title>
</head>
<body>
	<header class="container-fluid">
		<h1 class="row">Registro</h1>
	</header>

	<!-- nav -->
	<jsp:include page="navbar.jsp" />
	
	
	<main class="container-fluid">
		<!-- formulario de registro -->
		<div class="row">
			<div class="col-12 col-sm-6 col-md-6">
				<form class="g-3 needs-validation" action="<%=request.getContextPath() %>/RegistroServlet" method="post">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Nombre
						del Carrusel o Feria</label> <input type="text" class="form-control"
						id="exampleFormControlInput1" required name="nombre">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Link
						de la imagen</label> <input type="text" class="form-control"
						id="exampleFormControlInput1" required name="urlImagen">
					</div>
					<select class="form-select" aria-label="Default select example" name="activo">
						<option value="1">Abierto</option>
						<option value="0">Cerrado</option>
					</select>
					<div class="mb-3">
						<label for="exampleFormControlTextarea1" class="form-label">Descricion
						del Carrusel o Feria</label>
						<textarea class="form-control" id="exampleFormControlTextarea1"
						rows="3" required name="descripcion"></textarea>
					</div>
					<button class="btn btn-primary" type="submit">Registrar...</button>
				</form>
			</div>
			<div class="col">
				<figure>
					<img src="https://s2.qwant.com/thumbr/0x380/5/5/85a3197b399586ce2a7560eef3ee82fb58ac4cac184b7037f941d0c7724c59/wp4223719.jpg?u=https%3A%2F%2Fwallpapercave.com%2Fwp%2Fwp4223719.jpg&q=0&b=1&p=0&a=0" width="90%" height="90%">
					<figcaption><i>Carnival In Rio De Janeiro</i></figcaption>
				</figure>
			</div>
		</div>
	</main>
</body>
<jsp:include page="footer.jsp"/>
</html>