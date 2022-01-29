package ar.com.educacionit.enums;

public class ConsoleLogger implements ILoger {

	@Override
	public void loguear() {
		System.out.println("Loguenado en Consola");

	}

}
