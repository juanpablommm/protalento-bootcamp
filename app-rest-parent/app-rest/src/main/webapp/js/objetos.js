/**
 * 
 */
const saludo = "hola ve...";
const numero = 10;
const numeroReal = 10.92;
const mm = true;

/*la palabra typeof funciona igual al instanceof de java,
permitiendonos saber el typo de una variable*/
alert("variable saludo tipo " + typeof saludo + " variable numero tipo " + typeof numero
+ " variable numeroReal tipo " + typeof numeroReal
+ " variable mm tipo " + typeof mm);

/*declarar un objeto al declarar un objeto como const
no puedo modificar su referencia a diferencia de hacerlo con
let, lo unico que si podria modificar son los valores de los atributos del
objeto*/
const persona = {
    dni: 120902,
    nombre: 'juancho roiz',
    idiomas: [
        'es', 'en', 'etc'
    ]
}
/* no se puede ya que el objeto fue declarado como constante
persona = {
    nombre: "noamos",
    apellido: "smam"
}
*/
alert("persona es de tipo " + typeof persona);

persona.dni = "cedula";
alert("dni de persona = " + persona.dni);

let articulo = {
    precio: 1.203,
    marca: "monito palito"

}
alert("articulo{" + articulo.precio + ", " + articulo.marca + "}");

articulo = {
    precio: 56.203,
    marca: "yellito"
}
alert("articulo{" + articulo.precio + ", " + articulo.marca + "}");


/*for para recorer un arreglo en js,
como no voy a alterala la variable i del
ciclo la declaro constante*/
for(const i of persona.idiomas){
    alert(i);
}

for(let i in persona){  
    alert("atributo " + i); 
    if(i == "dni"){
        i = "nuevo dni";
        alert("atributo " + i); 
    }
}

/* datos nulo,  undefined, null, NaN*/
let nulo = undefined;
let na = NaN;
let h = null;
alert("variable nulo = " + nulo + " variable na = " + na + " variable h = " + h);