package com.tecso.app.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class AlumnoPersonaDTO implements Serializable {
	private static final long serialVersionUID = 4343833472073118551L;
	
	private Long idAlumno;
	
	private String tipoDoc;
	
	private BigInteger documento;
	
	private String nombre;
	
	private String apellido;
	
	private String fechaNac;
	
	private String direccion;
	
	private Integer legajo;

	public AlumnoPersonaDTO() {
		super();
	}

	public AlumnoPersonaDTO(Long idAlumno, String tipoDoc, BigInteger documento, String nombre, String apellido,
			String fechaNac, String direccion, Integer legajo) {
		super();
		this.idAlumno = idAlumno;
		this.tipoDoc = tipoDoc;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.legajo = legajo;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
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

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

}