package ejercicios;

public class Alumno {
	
	private Persona persona;
	
	private Integer legajo;

	public Alumno() {
		
	}

	public Alumno(Persona persona, Integer legajo) {
		super();
		this.persona = persona;
		this.legajo = legajo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	
}
