package com.tecso.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecso.app.model.Alumno;
import com.tecso.app.repository.AlumnoRepository;
import com.tecso.app.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepo;

	@Override
	public Alumno obtenerAlumnoPorIdPersona(Long idPersona) {
		
		return alumnoRepo.findByPersona(idPersona);
	}

	@Override
	public void guardarOActualizar(Alumno alumno) {
		alumnoRepo.save(alumno);
		
	}

	@Override
	public void eliminarAlumno(Long id) {
		alumnoRepo.deleteById(id);
	}

	@Override
	public Alumno obtenerAlumnoPorId(Long idAlumno) {
		
		Optional<Alumno> alumnoOpt = alumnoRepo.findById(idAlumno);
		
		if(alumnoOpt != null) {
			return alumnoOpt.get();
		}
		
		return null;
	}

	@Override
	public List<Alumno> buscarTodosLosAlumnos() {
		Iterable<Alumno> alumnos = alumnoRepo.findAll();
		List<Alumno> rta = new ArrayList<Alumno>();
		while(alumnos.iterator().hasNext()) {
			rta.add(alumnos.iterator().next());
		}
		return rta;
	}

	@Override
	public Alumno obtenerAlumnoPorLegajo(Integer legajo) {
		return alumnoRepo.findByLegajo(legajo);
	}

}
