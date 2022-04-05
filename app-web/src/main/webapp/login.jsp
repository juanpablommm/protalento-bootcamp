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

<%--     <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/style.css"> --%>
<!-- CSS only (bootstap)-->
<link href="<%=request.getContextPath()%>/styles/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
    <header>
        
    </header>
    <main>
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-xl-6">
                    
                    <form action="">
					  <div class="mb-3 row">
					   <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
					   <div class="col-sm-10">
					     <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="email@example.com">
					   </div>
					 </div>
					 <div class="mb-3 row">
					   <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
					   <div class="col-sm-10">
					     <input type="password" class="form-control" id="inputPassword">
					   </div>
					 </div>
                    </form>
                    
                </div>
                <div class="col-md-12 col-xl-6">
                    
					<form class="row g-3 needs-validation" novalidate>
					  <div class="col-md-4">
					    <label for="validationCustom01" class="form-label">First name</label>
					    <input type="text" class="form-control" id="validationCustom01" value="Mark" required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  <div class="col-md-4">
					    <label for="validationCustom02" class="form-label">Last name</label>
					    <input type="text" class="form-control" id="validationCustom02" value="Otto" required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  <div class="col-md-4">
					    <label for="validationCustomUsername" class="form-label">Username</label>
					    <div class="input-group has-validation">
					      <span class="input-group-text" id="inputGroupPrepend">@</span>
					      <input type="text" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend" required>
					      <div class="invalid-feedback">
					        Please choose a username.
					      </div>
					    </div>
					  </div>
					  <div class="col-md-6">
					    <label for="validationCustom03" class="form-label">City</label>
					    <input type="text" class="form-control" id="validationCustom03" required>
					    <div class="invalid-feedback">
					      Please provide a valid city.
					    </div>
					  </div>
					  <div class="col-md-3">
					    <label for="validationCustom04" class="form-label">State</label>
					    <select class="form-select" id="validationCustom04" required>
					      <option selected disabled value="">Choose...</option>
					      <option>...</option>
					    </select>
					    <div class="invalid-feedback">
					      Please select a valid state.
					    </div>
					  </div>
					  <div class="col-md-3">
					    <label for="validationCustom05" class="form-label">Zip</label>
					    <input type="text" class="form-control" id="validationCustom05" required>
					    <div class="invalid-feedback">
					      Please provide a valid zip.
					    </div>
					  </div>
					  <div class="col-12">
					    <div class="form-check">
					      <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
					      <label class="form-check-label" for="invalidCheck">
					        Agree to terms and conditions
					      </label>
					      <div class="invalid-feedback">
					        You must agree before submitting.
					      </div>
					    </div>
					  </div>
					  <div class="col-12">
					    <button class="btn btn-primary" type="submit">Submit form</button>
					  </div>
					</form>
                    
                </div>
            </div>

        </div>
    </main>
</body>
</html>