<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<%@page import="ar.com.educacionit.domain.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
/*objetos implicitos que tiene las jsp*/
Users users = (Users) session.getAttribute(ViewsKeysEnum.USER.getName());
%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="styles.jsp" />
<title>System</title>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	
	<main>
		<!-- section para alertas para mostrar errores -->
		<jsp:include page="alertas.jsp"></jsp:include>
		<!-- section principal -->
		<section class="container">
			<div class="row d-flex justify-content-center">
				<div class="col-6">
					<hgroup>
						<h1>
							Username:
							<%=users.getUsername()%></h1>
						<h2>
							Nombre:
							<%=users.getSocio().getNombre()%></h2>
						<h3>
							Apellido:
							<%=users.getSocio().getApellido()%></h3>
					</hgroup>
						<a href="<%=request.getContextPath()%>/controllers/BuscarProductosServlet">Ver
							listado</a>
				</div>
			</div>
		</section>
	</main>
	<jsp:include page="js/scripts.jsp" />
</body>
</html>