package domain.persona;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import domain.idiomas.Español;
import domain.idiomas.Idioma;
import exeptions.GenericCRUDExeption;

public class Persona {

	private String nombre;
	private String apellido;
	private Integer edad;
	private Set<Class<? extends Idioma>> idiomas = new HashSet<>();

	public Persona(String nombre, String apellido, Integer edad, Class<? extends Idioma> idiomaNativo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		if (idiomas.size() == 0) {
			this.idiomas.add(idiomaNativo);
		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Set<Class<? extends Idioma>> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(Class<? extends Idioma> idioma) throws GenericCRUDExeption {
		if (this.idiomas.contains(idioma)) {
			throw new GenericCRUDExeption("Error!! " + getNombre() + " ya sabe " + idioma.getSimpleName());
		} else {
			idiomas.add(idioma);
			System.out.println("Registro exitoso juan ahora sabe " + idioma.getSimpleName());
		}

	}

	
	
	

	@Override
	public String toString() {
		String totalidiomas = "";
		for (Class<? extends Idioma> idioma: idiomas) {
			totalidiomas += idioma.getSimpleName() + ",";
		}
		return nombre + " " + apellido + ", " + edad + " años, habla " + totalidiomas.substring(0, (totalidiomas.length() - 1));
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre);
	}
	
	

}
