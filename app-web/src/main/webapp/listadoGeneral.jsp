<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<html lang="es">
<head>
<title>Listado</title>
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
		<section class="container-fluid">
			<div class="row">
				<div class="col-12- col-sm-12 col-md-4 col-ls-4 col-xl-4 col-xxl-4">
					<form>
						<div class="mb-3">
							<label for="disabledTextInput" class="form-label">Titulo</label> <input type="text"
								class="form-control">
						</div>
						<div class="mb-3">
							<label for="disabledSelect" class="form-label">Orden de filtrado</label> <select class="form-select">
								<option>Seleccione el orden...</option>
								<option>ASC</option>
								<option>DSC</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">Filtrar</button>
					</form>
				</div>
				<div class="col">
					<h1 class="tituloArticulosGeneral">Listado de Articulos</h1>
					<table class="table table-dark table-hover">
						<thead>
							<tr>
								<th scope="col">Titulo</th>
								<th scope="col">Precio</th>
								<th scope="col">Codigo</th>
								<th scope="col">Stock</th>
								<th scope="col">Marca-ID</th>
								<th scope="col">Categoria-ID</th>
							</tr>
						</thead>
						<tbody>

							<%
							Collection<Articulos> articulos = (Collection<Articulos>) request.getSession().getAttribute(ViewsKeysEnum.LISTADO.getParam());
							if (articulos == null) {
							    articulos = new ArrayList<>();
							}
							for (Articulos articulo : articulos) {
							%>
							<tr>
								<th scope="col"><%=articulo.getTitulo()%></th>
								<td><%=articulo.getPrecio()%></td>
								<td><%=articulo.getCodigo()%></td>
								<td><%=articulo.getStock()%></td>
								<td><%=articulo.getMarcasId()%></td>
								<td><%=articulo.getCategoriasId()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</main>

	<!-- importo mi jsp que contien la parte javascrip de bootrat -->
	<jsp:include page="js/scripts.jsp"></jsp:include>
</body>
</html>