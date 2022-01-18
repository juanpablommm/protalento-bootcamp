package ar.com.educacionit.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import ar.com.educacionit.dao.impl.SocioDaoImpl;

public class MainCuenta {

	public static void main(String[] args) throws Exception {

//		quiero tomar una clase  .class y setear los
//		datos (atributos) dentro de una template

		Cuenta miCuenta = new Cuenta(100l, "caja de ahorros", 150000f);

//		construir un string que tenga
//		Cuenta= {atributo = valor| atributo2 = valor}

		String template = buildTemplate(miCuenta);
		System.out.println(template);

		Socios socios = new SocioDaoImpl().getOne(1l);
		template = buildTemplate(socios);
		System.out.println(template);
		
		Categorias cat = new Categorias();
		cat.setCodigo("100");
		cat.setDescripcion("desc100");
		cat.setId(1500l);
		template = buildTemplatewithMethods(cat);
		System.out.println(template);

	}

	public static String buildTemplate(Class clazz, Object data) throws Exception {

		String className = clazz.getSimpleName();// nombre clase

		StringBuffer template = new StringBuffer(className);
		template.append("={");

//		tomo los atributos del clas
		Field fields[] = clazz.getDeclaredFields();

//		recorro los atributos
		for (Field f : fields) {
			f.setAccessible(true);// permitir aceder al atributo

			String name = f.getName();// nombre del atributo
			Object value = f.get(data);
			template.append(name).append(",").append(value.toString()).append("|");
		}

		template.append("}");

		return template.toString();
	}

	public static String buildTemplate(Object data) throws Exception {

		Class clazz = data.getClass();
		String className = clazz.getSimpleName();// nombre clase

		StringBuffer template = new StringBuffer(className);
		template.append("={");

//		tomo los atributos del clas
		Field fields[] = clazz.getDeclaredFields();

//		recorro los atributos
		for (Field f : fields) {
			f.setAccessible(true);// permitir aceder al atributo

			String name = f.getName();// nombre del atributo
			Object value = f.get(data);

			template.append(name).append("=");
			if (value != null) {
				template.append(value.toString()).append("|");
			} else {
				template.append("null");
			}
			template.append("|");
		}

		template.append("}");

		return template.toString();
	}

public static String buildTemplatewithMethods(Object data) throws Exception {
		
		Class clazz = data.getClass();
		String className = clazz.getSimpleName();//nombre clase
		
		StringBuffer template = new StringBuffer(className);
		template.append("={");
		
//		tomo los atributos del clas
		Method methods[] = clazz.getDeclaredMethods();
		
//		recorro los atributos
		for(Method method: methods) {
			method.setAccessible(true);//permitir aceder al atributo
			Object value = null;
			String name = method.getName();//nombre del atributo
			if(name.startsWith("get")) {
				value = method.invoke(data);
				
				template.append(name).append("=");
				if (value != null) {
					template.append(value.toString()).append("|");
				}else {
					template.append("null");
				}
				template.append("|");
			}
			}
			
		
		template.append("}");
		
		return template.toString();
	}
}
