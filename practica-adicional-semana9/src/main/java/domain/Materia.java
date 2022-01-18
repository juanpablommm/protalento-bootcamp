package domain;

public class Materia {

//	id, Curso,Turno

	private Long id;
	private String curso;
	private Integer turno;
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}

	public Materia(String curso, Integer turno) {
		this.curso = curso;
		this.turno = turno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Materia: id=" + id + ", curso=" + curso + ", turno=" + turno;
	}

}
