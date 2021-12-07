package clase9.oop.interfaces;

public class Avion extends Volador implements Aterrizable{
//
//	al implementar una interface estoy obligado
//	a invocar el metodo que estatenga,
//	y el comportamiento de este metodo lo 
//	agregamos en la misma clase que estamos
//	implementando esa interfcas, por ende
//	se dice una interface es una clase
//	abstracat pura
	public void aterrizar() {
		// TODO Auto-generated method stub
		System.out.println("Ele avion aterriza ");
	}

}
