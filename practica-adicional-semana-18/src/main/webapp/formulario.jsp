<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<jsp:include page="metasAndLinks.jsp" />

<style type="text/css">
	#particles-js{
		width: 100%;
		height: 300px;
	}
</style>
</head>
<body>
	
<main class="container-fluid contenedor">
			<div class="row">
				<div class="col-8 col-sm-8 col-md-6 col-lg-6 col-xl-4 col-xxl-4">
					
					<form id="formRegistro" >
	
					<div class="mb-3">
						<label for="formRegistro">Nombres Completo</label>
						<span id="obligacion-nombres" >*No puede estar vacio ni contener numeros</span>
						<input type="text" class="form-control" name="nombres">
					</div>
						
					<div class ="mb-3">
					<label id="label-correo">Corrreo Electronico</label>
						<span id="obligacion-correo" >*correo invalido</span>
						<input type="email" class="form-control" id="correo" name="correo" placeholder="name@example.com">
					</div>
	
					
					<div class="genero mb-3">
						<label>Selecione Genero</label>
						<span id="oblogacion-genero">*Debe selecionar el genero</span>
						<div class="form-check">
							<input type="radio" class="form-check-input" id="validationFormCheck2" name="radioGenero" value="Hombre" >
							<label class="form-check-label">Hombre</label>
						</div>
						
						<div class="form-check mb-3">
							<input type="radio" class="form-check-input" id="validationFormCheck3" name="radioGenero" value="Mujer">
							<label class="form-check-label" for="validationFormCheck3">Mujer</label>
						</div>
					</div>
					
					
					<div class="tecnologias  mb-3">
						<label>Tecnologias</label><br>
						<input type="checkbox" class="form-check-input" value="Java" name="tecnologias"> 
						<label for="formRegistro">Java</label><br>
						<input type="checkbox" class="form-check-input" value="Python" name="tecnologias">
						<label for="formRegistro">Python</label><br>
						<input type="checkbox" class="form-check-input" value="MySQL" name="tecnologias"> 
						<label for="formRegistro">MySQL</label><br>
						<input type="checkbox" class="form-check-input" value="PHP" name="tecnologias">
						<label for="formRegistro">PHP</label><br>
						<input type="checkbox" class="form-check-input" value="Git and GitHub" name="tecnologias"> 
						<label for="formRegistro">Git and GitHub</label><br>
						<input type="checkbox" class="form-check-input" value="Firebase" name="tecnologias">
						<label for="formRegistro">Firebase</label><br>
					</div>
					
	
					<div class="mb-3">
						<label>Carrera</label>
						<span id="obligacion-carrera">*Debe seleccionar una carrera</span>
						<select class="form-select" required aria-label="select example" name="carrera">
							<option value="">Abre este menu de seleccione</option>
							<option value="Ingeniero de Sistemas">Ingeniero de Sistemas</option>
							<option value="Ingeniero de Telecomunicaciones">Ingeniero de Telecomunicaciones</option>
							<option value="Desarrollador Back-End">Desarrollador Back-End</option>
							<option value="Desarrollador Front-End">Desarrollador Front-End</option>
						</select>
					</div>
	
	
					<div class="mb-3">
						<div class="col">
							<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
							<span id="obligacion-password">*No puede estar vacio y debe de tener especials(*, %, &..), numeros y letras</span>
							<input type="password" class="form-control" id="password" name="password">
						</div>
						<div class="col">
							<label for="inputPassword" class="col-sm-2 col-form-label">Validate Password</label>
							<span id="obligacion-validatePassword">*Deben de concidir las passwords</span>
							<input type="password" class="form-control" id="validatePassword" name="validatePassword">
						</div>
					</div>
	
	
					<div class="mb-3">
						<button class="btn btn-primary" type="button" id="enviar" onclick="validar()">Submit
							form</button>
					</div>
				</form>
				
			</div>
			
			<!--se incluye el modal -->
			<jsp:include page="./modal.jsp"/>
				
		</div>
</main>


</body>
 <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</html>