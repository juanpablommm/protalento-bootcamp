<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<html lang="es">
<head>
<title>Listado</title>
<jsp:include page="styles.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>

	<main>
		<jsp:include page="alertas.jsp"></jsp:include>

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
								<th scope="col"></th>
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
								<!-- button eliminar que lanzara un modal de bootstrap -->
								<td>
									<!-- Button trigger modal -->
									<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#staticBackdrop"
									onclick="guardarID(<%=articulo.getId()%>)">
									  Eliminar
									</button>
								</td>
							</tr>
							<%
							}
							%>
						</tbody>
						<tfoot>
							<tr>
								<td>Total:</td>
								<td colspan="5"><%=request.getSession().getAttribute(ViewsKeysEnum.VALOR_TOTAL.getParam())%></td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</section>
			<!-- Modal -->
			<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="staticBackdropLabel">Eliminar</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        ¿Seguro quieres eliminar este registro?
			      </div>
			      <div class="modal-footer">
			      	<form action="<%=request.getContextPath()%>/controllers/EliminarArticuloServlet" method="post" id="formEliminar">
			      		<input type="hidden" name="id" id="<%=ViewsKeysEnum.ID_ELIMINAR.getParam()%>">
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
				        <button type="submit" class="btn btn-primary">Confirmar</button>
			      	</form>
			      </div>
			    </div>
			  </div>
			</div>
	</main>
	<jsp:include page="js/scripts.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/listadoGeneral.js"></script>
</body>
</html>