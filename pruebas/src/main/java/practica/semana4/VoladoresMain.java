package practica.semana4;

public class VoladoresMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Volador voladores[] = new Volador[5];
		voladores[0] = new Superman("Superman", 400f, false, true);
		voladores[1] = new Helicotero("Helicotero marvel", 463f, false, "negro", "Black Ops", "Bell Helicopter");
		voladores[2] = new Avion("Avion c", 1300f, false, 1, "Kafir", "Fuerza Aerea");
		voladores[3] = new Ovni("Ovni 7/12/2021", 900f, true, "Se observa un objecto volador"
				+ "\nno identificado en los alrededores del Dorado, vinculado con desapariciones");
		voladores[4] = new Helicotero("Helicotero batiship", 463f, true, "negro", "Black Ops", "Bell Helicopter");

		for (Volador volador : voladores) {
			volador.detallar();
			if (volador instanceof Aterrizable) {
				((Aterrizable) volador).aterrizar();
			}
		}
	}

}
