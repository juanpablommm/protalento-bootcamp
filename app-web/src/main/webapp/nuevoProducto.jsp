<%@page import="ar.com.educacionit.domain.Categorias"%>
<%@page import="ar.com.educacionit.domain.Marcas"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.educacionit.web.enums.ViewsKeysEnum"%>
<meta charset="utf-8">
<jsp:include page="styles.jsp" />
<title>Cargar Archivo</title>
</head>
<body>
	<!-- importo mi jps externa que contine el nav -->
	<jsp:include page="navbar.jsp"></jsp:include>

	<main>
		<!-- section para alertas para mostrar errores -->
		<jsp:include page="alertas.jsp"></jsp:include>

		
		<!-- recupero las lista de articulos -->
		<%
		List<Marcas> marcas = (List<Marcas>)request.getSession().getAttribute(ViewsKeysEnum.MARCAS.getParam());
		List<Categorias> categorias = (List<Categorias>)request.getSession().getAttribute(ViewsKeysEnum.CATEGORIAS.getParam());
		%>
		<!-- section principal -->
		<section class="container-fluid">
			<h1>Nuevo Producto</h1>
			<div class="row">
				<div class="col">
					<form class="row g-3 needs-validation" action="<%=request.getContextPath()%>/controllers/NuevoProductoServlet" method="post" novalidate>
					  <div class="col-md-4">
					    <label for="titulo" class="form-label">Titulo</label>
					    <input type="text" class="form-control" id="titulo" name="titulo" required minlength="10" maxlength="100">
					    <div class="valid-feedback">
					      Es Correcto!
					    </div>
					  </div>
					  <div class="col-md-4">
					    <label for="codigo" class="form-label">Codigo</label>
					    <input type="text" class="form-control" id="codigo" name="codigo" required minlength="1" maxlength="10">
					    <div class="valid-feedback">
					      Es Correcto!
					    </div>
					  </div>
					  <div class="col-md-4">
					    <label for="precio" class="form-label">Precio</label>
					    <input type="number" class="form-control" id="precio" name="precio" required min="0" max="99999999">
					    <div class="valid-feedback">
					      Es Correcto!
					    </div>
					  </div>
					  <div class="col-md-6">
					    <label for="stock" class="form-label">Stock</label>
					    <input type="number" class="form-control" id="stock" name="stock" required min="0" max="100">
					    <div class="valid-feedback">
					      Es Correcto!
					    </div>
					  </div>
					  <div class="col-md-3">
					     <label for="marcasId" class="form-label">Marcas id</label>
					     
					     <select class="form-select" id="marcasId" name="marcasId"aria-label="Default select example" required>
					     	<%for(Marcas marca: marcas){

					     	%>
					     	<option value="<%=marca.getId()%>"><%=marca.getDescripcion()%></option>
					     	<%
					     	}
					     	%>
						</select>
					    <div class="valid-feedback">
					      Es Correcto!
					    </div>
					  </div>
					  <div class="col-12">
					    <label for="categoriasId" class="form-label">CategoriasID</label>
					    <select class="form-select" id="categoriasId" name="categoriasId" required>
					    	<%for(Categorias categoria: categorias){
					    		
					    	%>
					    		<option value="<%=categoria.getId()%>"><%=categoria.getDescripcion()%></option>
					    	<%
					    		} 
					    	%>
					    </select>
					    <div class="valid-feedback">
					      Es Correcto!
					    </div>
					  </div>
					  <div class="col-12">
					    <button class="btn btn-primary" type="submit">Crear Producto</button>
					  </div>
					</form>
				</div>
			</div>
		</section>
	</main>

	<!-- importo mi jsp que contien la parte javascrip de bootrat -->
	<jsp:include page="js/scripts.jsp"></jsp:include>
	
	<script type="text/javascript">
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function () {
	  'use strict'
	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  var forms = document.querySelectorAll('.needs-validation')
	  // Loop over them and prevent submission
	  Array.prototype.slice.call(forms)
	    .forEach(function (form) {
	      form.addEventListener('submit', function (event) {
	        if (!form.checkValidity()) {
	          event.preventDefault()
	          event.stopPropagation()
	        }
	        form.classList.add('was-validated')
	      }, false)
	    })
	})()
	</script>
</body>
</html>