package ar.com.educacionit.Exeptions;

import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.domain.Socios;

public class MiPrimerExeptionMain {

	public static void main(String[] args) throws Exception {

//		jvm < errores uncheked, exepciones no
//		controladas, el programador no debe 
//		"preocuparse", el error lo carga la jmv
//		sin errores en tiempo de ejecucion
		int a = 10;
//		int b = 0;
		int b = 1;
		int c = a / b;
//		corta el programa
		System.out.println(c);
		// java.lang.ArithmeticExeption

//		ejemplo con objetos
//		Socios s = null;
		Socios s = new Socios();
		Long id = s.getId();
		System.out.println(id);
		// java.lang.NullPointerException

//		herencia / interfaces
		Object socio = new Socios();
//		Categorias cat = (Categorias) socio;
		Entity cat = (Entity) socio;
		System.out.println(cat.getId());
//		java.lang.ClassCastException

//		****************************************
//		jvm > errores de tipo cheked, son errores
//		que obligan al programador a controlarlos,
//		estas con errores en tiempo de compilacion

//		try {
			metodoConExeption(10);
//			ok
//		} catch (Exception nombre) {
//			error
//			las excepciones tine un stackTrace;
//			que es cunado invocamos un metodo, este invoca
//			a otro y a su vez este a otro y asi 
//			sucecivamente y despues se devuelven
//			con el metodo printStackTrace() imprimos
//			en que metodo se ropmio el prograna
//			nombre.printStackTrace();

//		}

	}

	public static void metodoConExeption(int valor) throws Exception {
		if (valor == 0) {
//		lanzo una Exeption
			throw new Exception("el valor es erroneo");
		}
		methodB();
	}
	
	public static void methodB() throws Exception{
//		method C
	}
}
