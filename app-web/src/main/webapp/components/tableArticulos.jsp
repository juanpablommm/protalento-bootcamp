<!-- agrego table -->
<%@page import="ar.com.educacionit.web.enums.IEnumerable"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.Collection"%>
<table class="table">
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
Collection<Articulos> articulos = (Collection<Articulos>) session.getAttribute(ViewsKeysEnum.UPLOAD_PREVIEW_KEY.getName());
if(articulos == null){
    articulos = new ArrayList<Articulos>();
}
		for(Articulos articulo: articulos){
%>
		<tr>
			<th scope="col"><%=articulo.getTitulo()%></th>
			<td><%=articulo.getPrecio()%></td>
			<td><%=articulo.getCodigo()%></td>
			<td><%=articulo.getStock()%></td>
			<td><%=articulo.getMarcasId()%></td>
			<td><%=articulo.getCategoriasId()%></td>
		</tr>
		<%}%>
	</tbody>
</table>
