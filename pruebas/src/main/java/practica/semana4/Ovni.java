package practica.semana4;

public class Ovni extends Volador {
	private String descripcion;

	public Ovni(String nombre, float velocidad, boolean amenaza, String descripcion) {
		super(nombre, velocidad, amenaza);
		this.descripcion = descripcion;
	}

	@Override
	public void detallar() {
		// TODO Auto-generated method stub
		super.detallar();
		System.out.println("Descripcion: " + descripcion);
	}
}
