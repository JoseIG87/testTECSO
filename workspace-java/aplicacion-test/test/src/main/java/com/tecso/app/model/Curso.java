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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "curso")
@Table(name = "curso")
public class Curso implements Serializable {
	private static final long serialVersionUID = 5115989241127829612L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "identificador", nullable=false)
	private Long id;
 
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idcarrera", nullable=true)
	private Carrera idCarrera;
	
	@Column(name = "nombre", nullable=false)
	private String nombre;
 
	@Column(name = "descripcion", nullable=true)
	private String descripcion;
	
	@Column(name = "cupomaximo", nullable=false)
	private Integer cupoMaximo;
 
	@Column(name = "anio", nullable=false)
	private Integer anio;
	
	@OneToMany(mappedBy="idCurso")
    private List<InscripcionesCurso> inscripcionesCurso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="iddocente", referencedColumnName="identificador")})
    private Docente idDocente;

	public Curso() {
		super();
		this.inscripcionesCurso = new ArrayList<InscripcionesCurso>();
	}
	
	public Curso(long id, Carrera idCarrera, String nombre, String descripcion, Integer cupoMaximo, Integer anio,
			List<InscripcionesCurso> inscripcionesCurso, Docente idDocente) {
		super();
		this.id = id;
		this.idCarrera = idCarrera;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cupoMaximo = cupoMaximo;
		this.anio = anio;
		this.inscripcionesCurso = inscripcionesCurso;
		this.idDocente = idDocente;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Carrera getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Carrera idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCupoMaximo() {
		return cupoMaximo;
	}

	public void setCupoMaximo(Integer cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
	public Docente getDocente() {
		return idDocente;
	}

	public void setDocente(Docente docente) {
		this.idDocente = docente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<InscripcionesCurso> getInscripcionesCurso() {
		return inscripcionesCurso;
	}

	public void setInscripcionesCurso(List<InscripcionesCurso> inscripcionesCurso) {
		this.inscripcionesCurso = inscripcionesCurso;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", idCarrera=" + idCarrera + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", cupoMaximo=" + cupoMaximo + ", anio=" + anio + ", inscripcionesCurso=" + inscripcionesCurso
				+ ", docente=" + idDocente + "]";
	}

}
