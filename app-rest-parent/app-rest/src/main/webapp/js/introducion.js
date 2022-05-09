/**
 * 
 */

 /*variables globales, las varibales globales en js se definen con var*/
 var varglobal = 34;

 /*variables locales, las variables locales se definene en js con let*/
 let varLocal = 'juancho roiz';

 /*contantes, las constantes en javascript se definen con const*/
 const contante = true;

 /*traigo el tag de html con el atibuto id = "exampleInputPassword1"*/
 /*let password = document.getElementById("exampleInputPassword1");*/

 /*imprimo el tag por console*/
 /*console.log(password);*/

 /*varible boolean que retornara la funcion*/
 var retorno  = false;

 function validar(){
    /*debugger;*//*la palabra debugger me permite establcer
    un brackpoint desde este punto e inicie un debug
    cuando llegue a esta linea de codigo la pagina
    sin necesidad de hacerlo desde la consola del navegador*/

    //capturar los tag input del html
    let password = document.getElementById("exampleInputPassword1");
    let username = document.getElementById("exampleInputEmail1");

    //capturar valor de los tag
    const valuePassword = password.value;
    const valueUsername = username.value;

    //validar el contenido
    /*a diferencia de java con javascript dado el typado
    que nameja tenemos que validar diferencia y similitud
    con dos == dado que de esta manera comprobaremos el tipo
    de dado de la varibale mas el contenido, pues pueden
    a ver dos variables con el mismo nombre pero de diferente
    tipo*/
    if(valueUsername.trim() !== "" && valuePassword.trim() !== ""){
        alert("Formulario validado enviado los datos...")
        retorno = true;
    }else {
        alert("Formulario invalido verifique los datos...")
    }
    return retorno;
 }