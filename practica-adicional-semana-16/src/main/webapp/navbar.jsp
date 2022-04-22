<!-- imports -->
<%@page import="com.educacionit.service.enums.ViewsEnums"%>

<div class="container-fluid">
	<div class="row">
		<nav class="navbar navbar-expand-lg navbar-dark">
			<div class="container-fluid">
				<button class="navbar-toggler boton-nav" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03"
					aria-controls="navbarTogglerDemo03" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active texto" aria-current="page" 
						href="<%=request.getContextPath() + ViewsEnums.HOME.getView()%>">Listado</a></li>
						<li class="nav-item"><a class="nav-link active texto"
							aria-current="page"
							href="<%=request.getContextPath() + ViewsEnums.REGISTRO.getView()%>">Registrar</a></li>
						<li class="nav-item">
						<a class="nav-link active texto" aria-current="page" href="<%=request.getContextPath()%>/ListadoImagenesServlet">Actualizar-Eliminar</a></li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>
	</div>
</div>