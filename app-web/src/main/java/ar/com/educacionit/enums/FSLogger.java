package ar.com.educacionit.enums;

public class FSLogger implements ILoger{

	@Override
	public void loguear() {
		System.out.println("Loguenado con file System");
		
	}

}
