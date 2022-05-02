/**
 * Se realizan las comprobaciones malues para saber si los 
campos del formulario son correctos mediante regex, para 
saber si un correo es valido o no, para saber si el nombre 
no tien numeros y la passwords tiene caracteres espciales
mas numeros y letras si todo sale bien se abre el modal
de lo contrario se marca que campo no es valido
 */
function validar() {
	let formulario = document.getElementById("formRegistro");
	if(formulario.nombres.value.match(/[0-9]/g) || !formulario.nombres.value.match(/[a-z]/ig)) {
		document.getElementById("obligacion-nombres").style.display = "inline";
		formulario.nombres.style.border = "2px solid #f00";
	}else if(!formulario.correo.value.match(/[@]/g) || !formulario.correo.value.match(/(com)$/g)) {
		document.getElementById("obligacion-correo").style.display = "inline";
		formulario.correo.style.border = "2px solid #f00";
	}else if(formulario.radioGenero.value == ""){
		document.getElementById("oblogacion-genero").style.display = "inline";
	}else if(formulario.carrera.value == ""){
		document.getElementById("obligacion-carrera").style.display="inline";
		formulario.carrera.style.border = "2px solid #f00";
	}else if(!formulario.password.value.match(/[^\w]/g) || !formulario.password.value.match(/[0-9]/g) || !formulario.password.value.match(/[a-z]/ig)) {//regex encontrar caracteres especiales y la niego
		document.getElementById("obligacion-password").style.display = "inline";
		formulario.password.style.border = "2px solid #f00";
	}else if(formulario.validatePassword.value != formulario.password.value){
		document.getElementById("obligacion-validatePassword").style.display = "inline";
		formulario.validatePassword.style.border = "2px solid #f00";
	}else{	
		let div = document.getElementById("informacion");
		div.innerHTML = "<P>" + formulario.nombres.value + ", correo: " + formulario.correo.value
		+ ", " + formulario.radioGenero.value + ", " + formulario.carrera.value + ", password: " 
		+ formulario.password.value + "</P>";
		$('#registroModal').modal('show');
	}
}