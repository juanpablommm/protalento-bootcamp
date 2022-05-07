<!DOCTYPE html>
<%@page import="com.educacionit.service.enums.ViewsEnums"%>
<%@page import="com.educacionit.domain.Carrousel"%>
<%@page import="java.util.List"%>
<html>
<jsp:include page="/cabecera.jsp"></jsp:include>
<body>
	<header class="container-fluid">
		<h1 class="row">Registro</h1>
	</header>

	<!-- nav -->
	<jsp:include page="navbar.jsp" />
	
	
	<main class="container-fluid">
	<!-- formulario de registro -->
		<form class="row g-3 needs-validation" action="<%=request.getContextPath() %>/RegistroServlet" method="post">
			<div class="col-4">
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
	</main>
</body>
</html>