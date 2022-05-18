<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<html lang="es">
<head>
<title>Listado</title>
<jsp:include page="styles.jsp"></jsp:include>

<script type="text/javascript">
	async function editarID(id) {
		
		//hace la peticion asincrona (ajax)
		/*al trabajar con con promesas (await) la funcion
		tiene que llevar la palabra asyn antes de function*/
		let articuloJSON = await axios.get(`<%=request.getContextPath()%>/rest/ProductoRest?id=${id}`);
		
		articuloJSON = articuloJSON.data; 
		
		document.getElementById("idSpan").innerHTML = articuloJSON.id;
		document.getElementById("idInput").value = articuloJSON.id;
		document.getElementById("titulo").value = articuloJSON.titulo;
		document.getElementById("precio").value = articuloJSON.precio;
		document.getElementById("stock").value = articuloJSON.stock;
		
		const options={
				keyboard: true
		}
		var myModal = new bootstrap.Modal(document.getElementById('modalActulizar'), options);
		myModal.show();
		
		/*usar la libreria de axios para pedir informacion al servidor
		
		voy a tener el JSON que retorna 
		
		actulizar el form que esta en el modal
		
		tomamos los atributos del json y establecemos bvalores a los 
		inputs del form*/
		
	}
</script>
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
									<!-- Button trigger modal eliminar -->
									<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#staticBackdrop"
									onclick="guardarID(<%=articulo.getId()%>)">
									  Eliminar
									</button>
									<!-- Button trigger modal actulizar -->
									<button type="button" class="btn btn-primary"
									onclick="editarID(<%=articulo.getId()%>)">
									  Actulizar
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
			<!-- Modal para eliminar articulos -->
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
			
			<!-- Modal para actulizar articulos -->
			<div class="modal fade" id="modalActulizar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="staticBackdropLabel">Actulizar Articulo</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			      	<form id="formActulizar" action="<%=request.getContextPath()%>/rest/ProductoRest" method="post">
					  <div class="mb-3">
					  	<label for="exampleInputEmail1" class="form-label" style="color:black">ID</label>
					    <span id="idSpan"></span>
					    <input type="hidden" id="idInput" name="idInput">
					  </div>
					  <div class="mb-3">
					  	<label for="exampleInputEmail1" class="form-label" style="color:black">Titulo</label>
					    <input type="text" class="form-control" id="titulo" name="titulo">
					  </div>
					    <div class="mb-3">
					  	<label for="exampleInputEmail1" class="form-label" style="color:black">Precio</label>
					    <input type="number" class="form-control" id="precio" name="precio">
					  </div>
					  <div class="mb-3">
					  	<label for="exampleInputEmail1" class="form-label" style="color:black">Stock</label>
					    <input type="number" class="form-control" id="stock" name="stock">
					  </div>
					</form>
			      </div>
			      <div class="modal-footer">
			      	<button type="button" form="formActulizar" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
			        <button type="submit" form="formActulizar" class="btn btn-primary">Actulizar</button>
			      </div>
			    </div>
			  </div>
			</div>
	</main>
	<jsp:include page="js/scripts.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/listadoGeneral.js"></script>
	
<!--agrego la libreria axios por medio del sccrip para realizar 
la petion asicronica que vamos a usar en el modal
 -->
 <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</body>
</html>