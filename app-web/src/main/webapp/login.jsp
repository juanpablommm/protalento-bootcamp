<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="description"
	content="bootcamp protalento,
    mercado digital">
<meta name="keywords" content="jsp, protalento, bootcamp, educacion it">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/style.css">
<!-- CSS only (bootstap)-->
<link href="<%=request.getContextPath()%>/styles/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<header> </header>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Dropdown </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled">Disabled</a>
					</li>
				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<main>
		<div class="container">
			<div class="row">
			<!-- podemos establcer que la colomna principal tendra tales
			dimensiones para cada pantalla -->
				<div class="col-12 col-sm-6 col-md-8 col-lg-10 col-xl-6">
					<form class="row g-3">
						<div class="col-md-4">
							<label for="validationDefault01" class="form-label">First
								name</label> <input type="text" class="form-control"
								id="validationDefault01" value="Mark" required>
						</div>
						<div class="col-md-4">
							<label for="validationDefault02" class="form-label">Last
								name</label> <input type="text" class="form-control"
								id="validationDefault02" value="Otto" required>
						</div>
						<div class="col-md-4">
							<label for="validationDefaultUsername" class="form-label">Username</label>
							<div class="input-group">
								<span class="input-group-text" id="inputGroupPrepend2">@</span>
								<input type="text" class="form-control"
									id="validationDefaultUsername"
									aria-describedby="inputGroupPrepend2" required>
							</div>
						</div>
						<div class="col-md-6">
							<label for="validationDefault03" class="form-label">City</label>
							<input type="text" class="form-control" id="validationDefault03"
								required>
						</div>
						<div class="col-md-3">
							<label for="validationDefault04" class="form-label">State</label>
							<select class="form-select" id="validationDefault04" required>
								<option selected disabled value="">Choose...</option>
								<option>...</option>
							</select>
						</div>
						<div class="col-md-3">
							<label for="validationDefault05" class="form-label">Zip</label> <input
								type="text" class="form-control" id="validationDefault05"
								required>
						</div>
						<div class="col-12">
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="invalidCheck2" required> <label
									class="form-check-label" for="invalidCheck2"> Agree to
									terms and conditions </label>
							</div>
						</div>
						<div class="col-12">
							<button class="btn btn-primary" type="submit">Submit
								form</button>
						</div>
					</form>
				</div>

<!-- 				<div class="col-md-12 col-xl-4"> -->
<!-- 					<img -->
<!-- 						src="https://s2.qwant.com/thumbr/0x380/e/0/b5997a26038cb492e05f7c348135f10ecd4630d309861192e6168ae341ad2a/simpsons_PNG94.png?u=http%3A%2F%2Fpngimg.com%2Fuploads%2Fsimpsons%2Fsimpsons_PNG94.png&q=0&b=1&p=0&a=0" -->
<!-- 						class="img-fluid imagenes"> -->
<!-- 				</div> -->

				<!-- el elmento siguiente se puede adactar  al de arriba
				con simplemente establcer la clase col si mensionar que tipo
				de pantaalla es, pues esta tomara las columnas sobrantes que deje
				el elmento de arriba -->
				<div class="col">
					<form class="row g-3">
						<div class="col-auto">
							<label for="staticEmail2" class="visually-hidden">Email</label> <input
								type="text" readonly class="form-control-plaintext"
								id="staticEmail2" value="email@example.com">
						</div>
						<div class="col-auto">
							<label for="inputPassword2" class="visually-hidden">Password</label>
							<input type="password" class="form-control" id="inputPassword2"
								placeholder="Password">
						</div>
						<div class="col-auto">
							<button type="submit" class="btn btn-primary mb-3">Confirm
								identity</button>
						</div>
					</form>
				</div>
			</div>
	</main>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>