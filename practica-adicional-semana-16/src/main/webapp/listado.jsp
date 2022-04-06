<!DOCTYPE html>
<%@page import="com.educacionit.service.enums.ViewsEnums"%>
<%@page import="com.educacionit.domain.Carrousel"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="utf-8">
<meta name="description"
	content="bootcamp educacion it, java developer practica semana 16">
<meta name="keywprds" content="java, html, jsp, servlets">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Listado</title>
<link rel="stylesheet" href="./styles/bootstrap.min.css">
</head>
<body>
	<header class="container-fluid">
		<h1 class="row">Carrouseles</h1>
	</header>

	<!-- nav -->
	<jsp:include page="navbar.jsp" />


	<main class="container-fluid">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#ID</th>
					<th scope="col">Carrousel</th>
					<th scope="col">Descripcion</th>
					<th scope="col">Activo</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Carrousel> list = (List<Carrousel>) request.getAttribute("LISTADO");
				for (Carrousel carrousel : list) {
				%>
				<tr>
					<th scope="row"><%=carrousel.getIdCarrousel()%></th>
					<td>
						<figure class="figure">
							<img src="<%=carrousel.getImagen()%>" width="60%">
							<figcaption>
								<small><%=carrousel.getNombre()%></small>
							</figcaption>
						</figure>
					</td>
					<td><p><%=carrousel.getDescripcion()%></p></td>
					<td><%=(carrousel.getActivo() == 1) ? "Abierto" : "Cerrado"%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
</html>