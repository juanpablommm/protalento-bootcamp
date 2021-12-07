package clase9.oop.herencia;

public final class Director extends Persona {
	/*la palabra final a nivelde clase lo que nos permite es cortar la herencia
	es decir que ya ninguna clase podra heredar de esta al hacer uso de la
	pabra extends */
	
	
	private Integer empACargo;

	public Director(String nombre, String apellido, String colorPelo, Integer empACargo) {
		super(nombre, apellido, colorPelo);
		this.empACargo = empACargo;
	}

	public Integer getEmpACargo() {
		return empACargo;
	}

	public void setEmpACargo(Integer empACargo) {
		this.empACargo = empACargo;
	}

//	@Override
//	public void detalle() {
//		// TODO Auto-generated method stub
//		super.detalle();
//		System.out.println("Empleados a cargo: " + this.getEmpACargo());
//	}
	
//	implementar el metodo  abstracto del padre
	@Override
	public void detallar() {
		// TODO Auto-generated method stub
		System.out.println("Empleados a cargo: " + this.getEmpACargo());
	}
	
//	metodo estatico
	public static void  delegar(Empleado empleado, String tarea) {
		empleado.detallar();
		System.out.println("Ejecutando tarea delegada :" + tarea);
	}

}
