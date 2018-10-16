package com.tecso.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
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

@Entity(name = "inscripcionesCurso")
@Table(name = "inscripciones_curso")
@IdClass(InscripcionesCursoPK.class)
public class InscripcionesCurso implements Serializable {
	private static final long serialVersionUID = -443471402735206052L;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({@JoinColumn(name="idalumno", referencedColumnName="identificador")})
	private Alumno idAlumno;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="idcurso", referencedColumnName="identificador")})
	private Curso idCurso;
	
	@Column(name = "fechainscripcion", nullable=false)
	private Date fechaInscripcion;
	
	@Column(name = "fechafinalizacion", nullable=true)
	private Date fechaFinalizacion;
	
	@Column(name = "notafinal", nullable=true)
	private BigDecimal notaFinal;

	public InscripcionesCurso() {
		super();
	}

	public InscripcionesCurso(Alumno idAlumno, Curso idCurso, Date fechaInscripcion, Date fechaFinalizacion,
			BigDecimal notaFinal) {
		super();
		this.idAlumno = idAlumno;
		this.idCurso = idCurso;
		this.fechaInscripcion = fechaInscripcion;
		this.fechaFinalizacion = fechaFinalizacion;
		this.notaFinal = notaFinal;
	}

	public Alumno getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Alumno idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Curso getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public BigDecimal getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(BigDecimal notaFinal) {
		this.notaFinal = notaFinal;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	@Override
	public String toString() {
		return "InscripcionesCurso [idAlumno=" + idAlumno + ", idCurso=" + idCurso + ", fechaInscripcion="
				+ fechaInscripcion + ", fechaFinalizacion=" + fechaFinalizacion + ", notaFinal=" + notaFinal + "]";
	}
	
}
