<%@page import="com.educacionit.domain.Carrousel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- incluyo mi jsp que tiene en su mayoria todas las metas y el css mas
javascrip de bootstrap -->
<jsp:include page="metasAndLinks.jsp" />
<script type="text/javascript" src="js/actulizarEliminar.js"></script>
<title>Insert title here</title>
</head>
<body>
	<header class="container-fluid">
		<h1 class="row texto">Actualizacion Carrousel</h1>
	</header>
	<!-- nav -->
	<jsp:include page="navbar.jsp" />
	<main class="container-fluid">
		<table class="table">
			<thead>
				<tr class="row">
					<th class="col-3">Imagen</th>
					<th class="col-9">Descripcion-URL</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Carrousel> list = (List<Carrousel>) request.getAttribute("imagenes");
				for (int i = 0; i < list.size(); i++) {
					Carrousel carrousel = list.get(i);
				%>
				<tr class="row">
					<td class="col-3 col-sm-3 col-md-3">
						<figure class="figure">
							<img class="bb" src="<%=carrousel.getImagen()%>" width="90%">
							<!-- no se debe implemntar stylos en linea, pero solo
								lo hago para no crear un stilo extenro solo para modifcar esta etiqueta -->
							<figcaption>
								<i><%=carrousel.getNombre()%></i></i>
							</figcaption>
						</figure>
					</td>
					<td class="col">
					<!-- formulario para actilizar-->
					<form  method="post" id="formularioActulizar<%=i%>"></form>
							
							<div class="row mb-2">
								<textarea class="col-12 col-md-12" style="resize: none;"
									rows="4" name="descripcion" form="formularioActulizar<%=i%>"><%=carrousel.getDescripcion()%></textarea>
							</div>
							
							<div class="row mb-2">
								<label class="col-12 col-sm-12 col-md-1"><b>URL</b></label> 
								<input class="col-12 col-sm-12 col-md-9" type="text" name="url" value="<%=carrousel.getImagen()%>" 
								form="formularioActulizar<%=i%>"/>
								<div class="col">
									<label><b>#Id</b></label> <input type="text"
										name="id_carrousel" value="<%=carrousel.getIdCarrousel()%>"
										readonly="readonly" size="4" form="formularioActulizar<%=i%>"/>
								</div>
							</div>
							
							<div class="row mb-2">
								<select class="col-12 col-sm-12 col-md-2"
									aria-label="Default select example" form="formularioActulizar<%=i%>" name="activo">
									<option value="1">Abierto</option>
									<option value="0">Cerrado</option>
								</select>
								<div class="col-12 col-sm-12 col-md-4">
									<label><b>Nombre:</b></label>
									<input id="nombre" name="nombre" type="text" value="<%=carrousel.getNombre()%>">
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 col-md-6">
										<button type="button" class="btn btn-info col-4 col-sm-3"
										name="actualizar" form="formularioActulizar<%=i%>" onclick="actulizarEliminar('formularioActulizar<%=i%>', '<%=request.getContextPath()%>/ActulizarImagenesServlet')">Actualizar</button>
										<button type="button" class="btn btn-danger col-4 col-sm-3"
										name="elimnar" form="formularioActulizar<%=i%>" id="eliminar" onclick="actulizarEliminar('formularioActulizar<%=i%>','<%=request.getContextPath()%>/ElimnarImagenesServlet')">Eliminar</button>
									</div>
							</div>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
</body>
<jsp:include page="footer.jsp"/>
</html>