/**
 * Se crea la funcion para elimnar o actulizar uno de los registro de
 carurresel indepentiendemente del boton que se seleccione se llevara
 a un serlvlet o otro para relizar la operacion
 */
 function actulizarEliminar(nombreIDFormulario, newAction) {
		const formulario = document.getElementById(nombreIDFormulario);
		formulario.action = newAction;
		formulario.submit();
}