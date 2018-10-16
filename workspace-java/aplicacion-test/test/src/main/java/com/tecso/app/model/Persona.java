package com.tecso.app.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tecso.app.utils.TipoDocumento;

@Entity(name = "persona")
@Table(name = "persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = -999319661819220131L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "identificador", nullable=false)
	private long id;
 
	@Column(name = "tipodoc", nullable=false)
	private TipoDocumento tipoDoc;
	
	@Column(name = "documento", nullable=false)
	private BigInteger documento;
	
	@Column(name = "nombre", nullable=false)
	private String nombre;
	
	@Column(name = "apellido", nullable=false)
	private String apellido;
	
	@Column(name = "fechanac", nullable=false)
	private Date fechaNac;
	
	@Column(name = "direccion", nullable=true)
	private String direccion;
	
	@OneToMany(mappedBy="idPersonaAlumno")
    private List<Alumno> alumnos;
	
	@OneToMany(mappedBy="idPersonaDocente")
    private List<Docente> docentes;

	public Persona() {
		super();
		this.alumnos = new ArrayList<Alumno>();
		this.docentes = new ArrayList<Docente>();
	}
	
	public Persona(long id, TipoDocumento tipoDoc, BigInteger documento, String nombre, String apellido, Date fechaNac,
			String direccion, List<Alumno> alumnos, List<Docente> docentes) {
		super();
		this.id = id;
		this.tipoDoc = tipoDoc;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.alumnos = alumnos;
		this.docentes = docentes;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoDocumento getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumento tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public BigInteger getDocumento() {
		return documento;
	}

	public void setDocumento(BigInteger documento) {
		this.documento = documento;
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

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public List<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", tipoDoc=" + tipoDoc + ", documento=" + documento + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", direccion=" + direccion + "]";
	}

}
