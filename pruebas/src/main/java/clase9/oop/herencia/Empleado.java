package clase9.oop.herencia;

public class Empleado extends Persona {

//	atributo propio del empleado
	private Integer id;
	

	public Empleado(String nombre, String apellido, String colorPelo, Integer id) {
//		antes de nacer el empleado, nace persona
		super(nombre, apellido, colorPelo);

//		puedo "setear" los atributos
		this.id = id;
		
		//cantidadOrejas = 4;
	}

//	get/set

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	cambiar el comportamiento del padre (reutilizar lo del padre + lo propio)
	/*
	 * public void detalle() { super.detalle();
	 * 
	 * // muestre lo propio System.out.println("Id: " + this.getId()); }
	 */

	@Override
	public void detallar() {
		// TODO Auto-generated method stub
		System.out.println("Id: " + this.getId());
	}
	
	/*
	public int getCantidadOjos() {
		return 3;
		
	}
	*/

}
