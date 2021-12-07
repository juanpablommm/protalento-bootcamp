package practica.semana4;

public class Helicotero extends Volador implements Aterrizable {
	private String color;
	private String modelo;
	private String marca;

	public Helicotero(String nombre, float velocidad, boolean amenaza, String color, String modelo, String marca) {
		super(nombre, velocidad, amenaza);
		this.color = color;
		this.modelo = modelo;
		this.marca = marca;
	}

	@Override
	public void detallar() {
		// TODO Auto-generated method stub
		super.detallar();
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Color: " + color);
	}

	public void aterrizar() {
		// TODO Auto-generated method stub
		System.out.println("Tienes" + (super.amenaza ? " Denegado el aterrizaje "
				+ "\n tienes 30 segundos para aterrizar en la zona 2 antes de que ataquemos"
				:" Permitido aterrizar en nuestro Helipuerto"
						+ "\nAterrizando...."));

	}

}
