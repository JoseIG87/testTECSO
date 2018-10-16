package com.tecso.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "inscripcionesCarrera")
@Table(name = "inscripciones_carrera")
@IdClass(InscripcionesCarreraPK.class)
public class InscripcionesCarrera implements Serializable {
	private static final long serialVersionUID = 14223829103620910L;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="idalumno", referencedColumnName="identificador")})
	private Alumno idAlumno;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="idcarrera", referencedColumnName="identificador")})
	private Carrera idCarrera;
	
	@Column(name = "fechainscripcion", nullable=false)
	private Date fechaInscripcion;
	
	@Column(name = "fechafinalizacion", nullable=true)
	private Date fechaFinalizacion;

	public InscripcionesCarrera() {
		super();
	}
	
	public InscripcionesCarrera(Alumno idAlumno, Carrera idCarrera, Date fechaInscripcion, Date fechaFinalizacion) {
		super();
		this.idAlumno = idAlumno;
		this.idCarrera = idCarrera;
		this.fechaInscripcion = fechaInscripcion;
		this.fechaFinalizacion = fechaFinalizacion;
	}
	
	public Alumno getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Alumno idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Carrera getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Carrera idCarrera) {
		this.idCarrera = idCarrera;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	@Override
	public String toString() {
		return "InscripcionesCarrera [idAlumno=" + idAlumno + ", idCarrera=" + idCarrera + ", fechaInscripcion="
				+ fechaInscripcion + ", fechaFinalizacion=" + fechaFinalizacion + "]";
	}

}
