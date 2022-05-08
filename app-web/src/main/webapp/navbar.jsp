<!-- recupero mi objeto user de la seccion -->
<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<%@page import="ar.com.educacionit.domain.Users"%>
<%
Users user = (Users) session.getAttribute(ViewsKeysEnum.USER.getName());
%>

<%
if (user != null) {
%>
<nav class="navbar navbar-expand-lg navbar-light">
	<div class="container-fluid">
		<a class="navbar-brand"
			href="<%=request.getContextPath()%>/loginSuccess.jsp"
			style="color: #ffffff"> <img
			src="<%=request.getContextPath()%>/img/logo.gif" alt="" width="30"
			height="34" class="d-inline-block align-text-top"> Home
		</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<form class="d-flex"
						action="<%=request.getContextPath()%>/upload.jsp">
						<button class="btn btn-outline-success me-2" type="submit">Cargar
							Archivo</button>
					</form>
				</li>
				<li class="nav-item">
					<form action="d-flex">
						<button class="btn btn-outline-success me-2" type="button">Nuevo
							Producto</button>
					</form>
				</li>
			</ul>
			<form class="d-flex">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Buscar</button>
			</form>
			<form class="d-flex"
				action="<%=request.getContextPath()%>/LogoutServlet" method="get">
				<button type="submit" class="btn btn-outline-danger">Logout</button>
			</form>
		</div>
	</div>
</nav>

<%
}
%>