package practica.semana4;

public class Superman extends Volador{
	private boolean encubierto;

	public Superman(String nombre, float velocidad, boolean amenaza, boolean encubierto) {
		super(nombre, velocidad, amenaza);
		this.encubierto = encubierto;
	}

	
	@Override
	public void detallar() {
		// TODO Auto-generated method stub
		super.detallar();
		System.out.println("Encubierto: " + (encubierto ? "Clark Kent" : "Superman"));
	}

	
	
	
}
