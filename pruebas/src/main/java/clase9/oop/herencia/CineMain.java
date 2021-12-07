package clase9.oop.herencia;

public class CineMain {

	public static void main(String args[]) {
		
//		Persona persona = new Persona("persona1", "apellido1", "negro");
		Persona empleado = new Empleado("empleado1", "apelldioem1", "rojo", 1);
		Persona efectivo = new Efectivo("nombre efectivo1", "apellido efectivo 1", "rubio", 1);
		Persona conratado = new Contratado("nombre contratado1", "apellido contratado1", "azul", 1, 6);
		
		Persona director = new Director("nombre director", "apellido director", "negro", 10);
//		todas las personas pueden ir al cine
		Persona personas[] = new Persona[4];
//		personas[0] = persona;
		personas[0] = empleado;
		personas[1] = efectivo;
		personas[2] = conratado;
		personas[3] = director;
		
//		recorrer personas que entran al cine y quiero saber si son un Director
		for(Persona aux: personas) {
			
//			con aux tengo  acceso a todos los metdos public de persona
			aux.detalle();
			
			
			if(aux instanceof Director) {
//				toma al director que esta dentro de la persona
				//(clase)objeto > castear = casting
				Director d = (Director) aux;
				System.out.println("Director: tiene " + d.getEmpACargo() + " a cargo y va a una silla especial");
			}
			
		}
		
	}
	
	
}
