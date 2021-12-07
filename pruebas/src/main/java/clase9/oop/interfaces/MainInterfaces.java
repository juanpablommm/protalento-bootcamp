package clase9.oop.interfaces;

public class MainInterfaces {
	public static void main(String[] args) {
		Avion a = new Avion();
		Helicotero h = new Helicotero();
		Superman s = new Superman();
		
		
		Volador voladores[] = new Volador[] {a, h, s};
		
//		Interface nombre = new Interface(); no se pueden instanciar
		
		for(Volador v : voladores) {
			if (v instanceof Aterrizable) {
				Aterrizable atr = (Aterrizable)v;
				atr.aterrizar();
			}else {
				System.out.println(v + "No puede aterrizar, no cumple contrato");
			}
		}
	}

}
