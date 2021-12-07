package clase9.oop.herencia;

public class Contratado extends Empleado{
	private Integer periodo;

	

	public Contratado(String nombre, String apellido, String colorPelo, Integer id, Integer periodo) {
		super(nombre, apellido, colorPelo, id);
		this.periodo = periodo;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	@Override
	public void detalle() {
		// TODO Auto-generated method stub
		super.detalle();
		
		System.out.println("Periodo: " + this.getPeriodo());
	}
	
}
