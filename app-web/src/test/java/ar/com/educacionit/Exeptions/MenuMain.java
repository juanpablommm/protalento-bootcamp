package ar.com.educacionit.Exeptions;



public class MenuMain {

	public static void main(String[] args) {
		
//		try {
//			Integer op = MenuOptions.getMenu();
//			System.out.println("ejecutandp accion para el menu " + op);
//		} catch (InvalidMenuException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.exit(0);
//		}
		
		Integer op = MenuOptions.getMenu();
		System.out.println("ejecutandp accion para el menu " + op);
	}
}
