package com.tecso.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "alumno")
@Table(name = "alumno")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 746651389513819565L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "identificador", nullable=false)
	private long id;
 
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idpersona", referencedColumnName="identificador", nullable=false)
	private Persona idPersonaAlumno;
 
	@Column(name = "legajo", nullable=false)
	private Integer legajo;
	
	@OneToMany(mappedBy="idAlumno")
    private List<InscripcionesCarrera> inscripcionesCarrera;
	
	@OneToMany(mappedBy="idAlumno")
    private List<InscripcionesCurso> inscripcionesCurso;

	public Alumno() {
		super();
		this.inscripcionesCarrera = new ArrayList<InscripcionesCarrera>();
		this.inscripcionesCurso = new ArrayList<InscripcionesCurso>();
	}

	public Alumno(long id, Persona idPersona, Integer legajo, List<InscripcionesCarrera> inscripcionesCarrera,
			List<InscripcionesCurso> inscripcionesCurso) {
		super();
		this.id = id;
		this.idPersonaAlumno = idPersona;
		this.legajo = legajo;
		this.inscripcionesCarrera = inscripcionesCarrera;
		this.inscripcionesCurso = inscripcionesCurso;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Persona getIdPersonaAlumno() {
		return idPersonaAlumno;
	}

	public void setIdPersonaAlumno(Persona idPersonaAlumno) {
		this.idPersonaAlumno = idPersonaAlumno;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	
	public List<InscripcionesCarrera> getInscripcionesCarrera() {
		return inscripcionesCarrera;
	}

	public void setInscripcionesCarrera(List<InscripcionesCarrera> inscripcionesCarrera) {
		this.inscripcionesCarrera = inscripcionesCarrera;
	}

	public List<InscripcionesCurso> getInscripcionesCurso() {
		return inscripcionesCurso;
	}

	public void setInscripcionesCurso(List<InscripcionesCurso> inscripcionesCurso) {
		this.inscripcionesCurso = inscripcionesCurso;
	}

	@Override
	public String toString() {
		return String.format("Alumno[id=%d, idPersona='%s', legajo='%s']", id, idPersonaAlumno, legajo);
	}

}
