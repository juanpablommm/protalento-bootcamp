package practica.semana4;

public class Avion extends Volador implements Aterrizable{
	private int cantidadAcientos;
	private String modelo;
	private String aerolinea;
	
	public Avion(String nombre, float velocidad, boolean amenaza, int cantidadAcientos, String modelo,
			String aerolinea) {
		super(nombre, velocidad, amenaza);
		this.cantidadAcientos = cantidadAcientos;
		this.modelo = modelo;
		this.aerolinea = aerolinea;
	}
	
	
	@Override
	public void detallar() {
		// TODO Auto-generated method stub
		super.detallar();
		System.out.println("Modelo: " + modelo);
		System.out.println("Cantidad de Acientos: " + cantidadAcientos);
		System.out.println("Aerolinea: " + aerolinea);
	}
	
	public void aterrizar() {
		// TODO Auto-generated method stub
		System.out.println("Tienes" + (super.amenaza ? " Denegado el aterrizaje "
				+ "\n tienes 30 segundos para desenter en la pista 1, antes de que ataquemos"
				:" Permitido aterrizar en nuestra pista"
						+ "\nAterrizando...."));

	}
	
	
	
	

}
