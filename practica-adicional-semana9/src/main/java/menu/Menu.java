package menu;

import java.util.List;
import java.util.Scanner;
import exeptions.Exeptions_Number_Menu;

public class Menu {

	private static Scanner teclado = new Scanner(System.in);

	public static String[] Opciones() throws Exeptions_Number_Menu {
//			inscribir, eliminar inscripcion, buscar inscripcion
		System.out.println("------------------------------");
		System.out.println("+ practica-adicional-semana9 +");
		System.out.println("------------------------------");
		System.out.println("\tEliga una Opcion:");
		System.out.println("A.Inscribir \tB.Eliminar \tC.Buscar Inscripcion");
		System.out.println("D.Buscar Todos los Registros \tE.Actualizar Registro");
		System.out.println("Eleccion: ");
		String eleccion = teclado.next();

//		creo un vector de mis opciones del enum
		seleccion opcionesEnum[] = seleccion.values();
		for (seleccion s : opcionesEnum) {
			if (eleccion.equalsIgnoreCase(s.toString())) {
				System.out.println("--------------------------\nPara que tabla deseas hacer un " + s.getValor()
						+ ":\nA.Alumno\tB.Materia");
				String eleccion2 = teclado.next();
				selecionTablas opcionesEnumTablas[] = selecionTablas.values();
				for (selecionTablas st : opcionesEnumTablas) {
					if (eleccion2.equalsIgnoreCase(st.toString())) {
						return new String[] {s.getValor(), st.getValor()};
					} else if (st.ordinal() == (opcionesEnumTablas.length - 1) && !eleccion2.equals(st.toString())) {
						throw new Exeptions_Number_Menu(
								"Error!! Opcion '" + eleccion2 + "' invalidad verifique nuevamente");
					}
				}
			} else if (s.ordinal() == (opcionesEnum.length - 1) && !eleccion.equalsIgnoreCase(s.toString())) {
				throw new Exeptions_Number_Menu("Error!! Opcion '" + eleccion + "' invalidad verifique nuevamente");
			}
		}return null;
	}
}

//creo un enum para elecion de las opciones
enum seleccion {
	A("INSERT"), B("DELETE"), C("SELECT"), D("SELECT *FROM"), E("UPDATE");
	private String valor;
	private seleccion(String valor) {
		this.valor = valor;
	}
	public String getValor() {
		return valor;
	}
}

//creo un segundo enum para la eleccion de las tablas
enum selecionTablas {
	A("Alumno"), B("Materia");
	private String valor;
	private selecionTablas(String valor) {
		this.valor = valor;
	}
	public String getValor() {
		return valor;
	}
}
