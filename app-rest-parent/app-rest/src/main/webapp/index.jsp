<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

	<title>project cero</title>
</head>
<body>
	<main>
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<h1>Alata de Algo...</h1>
					<form action="<%=request.getContextPath()%>/controllers/HelloController" method="get" onsubmit="return validar()">
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Email address</label>
							<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" class="form-label">Password</label>
							<input type="password" class="form-control" id="exampleInputPassword1">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
	<!-- javascript -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/introducion.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/objetos.js"></script>
</html>