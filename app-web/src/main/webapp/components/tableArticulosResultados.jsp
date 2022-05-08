<!-- agrego table -->
<%@page import="ar.com.educacionit.web.enums.IEnumerable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.Collection"%>

<h1 class="tituloArticulosProcesados">Archivos Procesados</h1>
<div class="row">
<div class="col-12">
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
		Collection<Articulos> articulosOk = (Collection<Articulos>) request.getAttribute(ViewsKeysEnum.ARTICULOS_OK.getName());
		Collection<Articulos> articulosFails = (Collection<Articulos>) session.getAttribute(ViewsKeysEnum.ARTICULOS_FAILS.getName());
		if (articulosOk == null) {
		    articulosOk = new ArrayList<Articulos>();
		}
		for (Articulos articulo : articulosOk) {
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

<div class="row">
<div class="col-12">
<h1 class="tituloArticulosNoProcesados">Articulos No Procesados</h1>
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
		if (articulosFails == null) {
		    articulosFails = new ArrayList<Articulos>();
		}
		for (Articulos articulo : articulosFails) {
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
<div class="row">
	<div class="col-6 col-sm-4 col-md-3 col-lg-2 col-xl-2 col-xxl-2">
		<form action="<%=request.getContextPath()%>/controllers/GenerarArchivoErrorServlet>" method="post" class="row g-3 needs-validation" novalidate target="_new">
			<label for="validationCustom04" class="form-label">State</label> 
			<select name="typeFile" class="form-select" id="validationCustom04" required>
				<option selected disabled value="">Elegir Formato</option>
				<option value="pdf">PDF</option>
				<option value="csv">CSV</option>
				<option value="xlsx">XLSX</option>
			</select> 
			<a class="btn btn-outline-success me-2"
				href="<%=request.getContextPath()%>/controllers/CargarProductoServlet"
				role="button">Generar Reporte
			</a>
		</form>
	</div>
</div>