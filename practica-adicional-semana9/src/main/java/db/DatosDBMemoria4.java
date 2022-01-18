package db;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import exeptions.ExceptionGenericBD;
import util.ValidarDatos;

public class DatosDBMemoria4 {

	private static List<Object> listaAlumnos = new ArrayList<Object>();

	// metodo para inscribir a un alumno a la base de datos (listaAlumnos)
	public static Object inscribir(String tabla) throws ExceptionGenericBD {
		Object entity = null;
		String sqlNames = "", sqlValues = "";
		try {
			entity = Class.forName("domain." + tabla).newInstance();
			Field fields[] = entity.getClass().getDeclaredFields();
			for (Field field : fields) {
			if(field.getName().equals("id")) {
				field.setAccessible(true);
				field.set(entity, contarRegistro(entity.getClass()));
			}else if (!field.getName().equals("id")) {
					field.setAccessible(true);
					System.out.println(
							"Ingresa " + field.getName() + " para el " + entity.getClass().getSimpleName() + ": ");
					field.set(entity, ValidarDatos.tiposTeclado(field.getType().getSimpleName()));
					sqlNames += field.getName() + ",";
					if (field.getType().getSimpleName().equals("String"))
						sqlValues += "'" + field.get(entity) + "',";
					else
						sqlValues += field.get(entity) + ",";
				}
			}
			System.out.println("____________________________________" + "\nEJECUTANDO: " + "\nINSERT INTO "
					+ entity.getClass().getSimpleName() + "(" + sqlNames.substring(0, (sqlNames.length() - 1))
					+ ") VALUES (" + sqlValues.substring(0, (sqlValues.length() - 1)) + ")");
			listaAlumnos.add(entity);
		} catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
			throw new ExceptionGenericBD("Error!! fallaron los datos para " + tabla + " verificalos ", e);
		}
		return entity;
	}

//	metodo para eliminar a un alumno a la base de datos (listaAlumnos)
	public static Object eliminarIncripcion(Long id, String tabla) throws ExceptionGenericBD {
		Object registro = null; //objeto para contar si existe registro
		try {
			Class<?> clase = Class.forName("domain." + tabla);
			int tamaño_lista = listaAlumnos.size();
			for (int i = 0; i < tamaño_lista; i++) {
				Field fields[] = listaAlumnos.get(i).getClass().getDeclaredFields();
				for (Field field : fields) {
					if (field.getName().equals("id")) {
						field.setAccessible(true);
						if (field.get(listaAlumnos.get(i)) == id && listaAlumnos.get(i).getClass().equals(clase)) {
							registro = listaAlumnos.get(i);
							listaAlumnos.remove(i);
							tamaño_lista = listaAlumnos.size();
						}else registro = null;
					}
				}
			}if(registro != null)System.out.println("____________________________________" + "\nEJECUTANDO:" + "\nDELETE FROM "+ clase.getSimpleName() + " WHERE ID = " + id);
			else System.out.println("No se encontro un registro con id " + id + " en la tabla " + clase.getSimpleName());
		} catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException e) {
			throw new ExceptionGenericBD("Error!! fallaron los datos para " + id + " verficalos ", e);
		}
		return (registro == null)? null: registro;
	}
	

//	metodo para buscar inscripcion en la base de datos (listaAlumnos)

//	comparo que el id que me pasan por parametro sea
//	igual al valor del atributo id de alguno de los objetos de la lista, 
//	y con el parametro tabla busco crear una class a partir de ese nombre.
//	una vez obtenido el class busco en la lista que exita un objeto con ese id
//	y que sea del tipo de la clase que he creado si es asi retorno ese objeto
//	de lo contario un null
	public static Object buscarInscripcion(Long id, String tabla) throws ExceptionGenericBD{
		Object registro = null; //objeto para contar si existe registro
		try {
			Class<?> clase = Class.forName("domain." + tabla);
			for (Object object : listaAlumnos) {
				Field fields[] = object.getClass().getDeclaredFields();
				for (Field field : fields) {
					field.setAccessible(true);
					if (field.getName().equals("id")) {
						if(id.equals(field.get(object)) && object.getClass().equals(clase))
							registro = object;
						else registro =null;
					}
				}
			}if(registro != null)System.out.println("____________________________________" + "\nEJECUTANDO:" + "\nSELECT *FROM "+ clase.getSimpleName() + " WHERE ID = " + id);
			else System.out.println("No se encontro un registro con id " + id + " en la tabla " + clase.getSimpleName());
		} catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException e) {
			throw new ExceptionGenericBD("Error!! fallo la obtencion de la tabla " + tabla + " verficar ", e);
		}return (registro == null)?null:registro;
	}
	
//	creo un metodo para actulizar un registro
	public static Object atualizarInscripcion(Long id, String tabla) throws ExceptionGenericBD{
		String sqlNamesandValues = "";
		Object registro = null; //objeto para contar si existe registro
		try {
			Class<?> clase = Class.forName("domain." + tabla);
			for (Object object : listaAlumnos) {
				Field fields[] = object.getClass().getDeclaredFields();
				for (Field field : fields) {
					if (field.getName().equals("id")) {
						field.setAccessible(true);
						if (id == field.get(object) && object.getClass() == clase) {
							registro = object;
							
							Field fields2[] = registro.getClass().getDeclaredFields();
							for(Field field2: fields2) {
								if(!field2.getName().equals("id")) {
									field2.setAccessible(true);
									System.out.println("Ingresa " + field2.getName() + " para el " + clase.getSimpleName() + ": ");
									field2.set(registro, ValidarDatos.tiposTeclado(field2.getType().getSimpleName()));
									sqlNamesandValues += field2.getName() + " = '" + field2.get(registro) + "',";
								}
							}
							sqlNamesandValues = " SET " + sqlNamesandValues.substring(0, (sqlNamesandValues.length() - 1 )).toUpperCase();
						}else registro = null;
					}
				}
			}if(registro != null)System.out.println("____________________________________" + "\nEJECUTANDO:" + "\nUPDATE "+ clase.getSimpleName() + sqlNamesandValues + " WHERE ID = " + id);
			else System.out.println("No se encontro un registro con id " + id + " en la tabla " + clase.getSimpleName());
		} catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException e) {
			throw new ExceptionGenericBD("Error!! fallaron la actulizacion para " + id + " verficalos ", e);
		}return registro;
	}

//	metodo para abuscar todos los datos de una tabla en la base de datos(listaAlumnos)
	public static List<Object> busctarTodaInscripcion(String tabla) throws ExceptionGenericBD{
		List<Object> lista = new ArrayList<Object>();
		try {
			Class<?> clase = Class.forName("domain." + tabla);
			Object registro = null; //objeto para contar si existe q registro almenos
			for (Object object : listaAlumnos) {
				if (object.getClass().equals(clase)) {
					lista.add(object);
					registro = object;
				}else object = null;
			}
			if(registro != null)System.out.println("____________________________________" + "\nEJECUNTANDO: "+ "\nSELECT *FROM " + clase.getSimpleName());
			else System.out.println("La tabla " + clase.getSimpleName() + " no tine registros ");
		} catch (ClassNotFoundException e) {
			throw new ExceptionGenericBD("Error!! fallo la obtencion de tabla " + tabla + " verficalos ", e);
		}
		return lista;
	}

//	metodo para saber la cantidad de un objeto en especifico en la lista
	private static Long contarRegistro(Class<?> clase) {
		Long contador = 1l;
		for (Object object : listaAlumnos) {
			if (object.getClass() == clase) {
				contador++;
			}
		}
		return contador;
	}


}
