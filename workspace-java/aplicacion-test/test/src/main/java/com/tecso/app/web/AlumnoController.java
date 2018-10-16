package com.tecso.app.web;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tecso.app.dto.AlumnoPersonaDTO;
import com.tecso.app.dto.CarreraCursosDTO;
import com.tecso.app.model.Alumno;
import com.tecso.app.model.Curso;
import com.tecso.app.model.InscripcionesCarrera;
import com.tecso.app.model.InscripcionesCurso;
import com.tecso.app.model.Persona;
import com.tecso.app.service.AlumnoService;
import com.tecso.app.service.CursoService;
import com.tecso.app.service.InscripcionesCursoService;
import com.tecso.app.service.PersonaService;
import com.tecso.app.utils.TipoDocumento;

@RestController
@RequestMapping("/alumnos")
@EnableAutoConfiguration
public class AlumnoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AlumnoController.class);
	
	@Autowired
	AlumnoService servicioAlumno;
	
	@Autowired
	PersonaService servicioPersona;
	
	@Autowired
	CursoService servicioCurso;
	
	@Autowired
	InscripcionesCursoService servicioInscripcionesCurso;
	
	@RequestMapping(path="/obteneralumnos",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Alumno>> findAll() {
		
		List<Alumno> alumnos = servicioAlumno.buscarTodosLosAlumnos();
		if(alumnos.isEmpty()) {
			LOG.info("No se encontro alumnos");
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
	}
	
	@RequestMapping(path="/obteneralumno/{alumnoDni}",method=RequestMethod.GET)
	public ResponseEntity<AlumnoPersonaDTO> obtenerPorDni(@PathVariable BigInteger alumnoDni) {
		
		Persona persona = servicioPersona.obtenerPersonaPorDni(alumnoDni);
		
		if(persona == null) {
			LOG.info("No se encontro alumno con dni: "+alumnoDni);
			return ResponseEntity.notFound().build();
		}
		
		Alumno alumno = new Alumno();
		
		for(Alumno al : persona.getAlumnos()) {
			if(!al.getInscripcionesCarrera().isEmpty()) {
				for(InscripcionesCarrera ic : al.getInscripcionesCarrera()) {
					if(ic.getFechaFinalizacion() == null) {
						alumno = al;
					}
				}
			}
		}
		
		AlumnoPersonaDTO alumnoDto = new AlumnoPersonaDTO();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
        String fechaNacS = dateFormat.format(persona.getFechaNac());
		
		alumnoDto.setTipoDoc(persona.getTipoDoc().toString());
		alumnoDto.setDocumento(persona.getDocumento());
		alumnoDto.setNombre(persona.getNombre());
		alumnoDto.setApellido(persona.getApellido());
		alumnoDto.setFechaNac(fechaNacS);
		alumnoDto.setDireccion(persona.getDireccion());
		alumnoDto.setLegajo(alumno.getLegajo());
		alumnoDto.setIdAlumno(alumno.getId());
		
		return new ResponseEntity<AlumnoPersonaDTO>(alumnoDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> guardarAlumnoPersona(@RequestBody AlumnoPersonaDTO persona) throws ParseException {
		
		Persona personaGuardar = servicioPersona.obtenerPersonaPorDni(persona.getDocumento());
		Alumno alumnoGuardar = servicioAlumno.obtenerAlumnoPorLegajo(persona.getLegajo());
		String info = "modificado";
		if(personaGuardar == null) {
			personaGuardar = new Persona();
		}
		if(alumnoGuardar == null) {
			alumnoGuardar = new Alumno();
			alumnoGuardar.setLegajo(persona.getLegajo());
			info = "creado";
		}
		Date fechaNac=new SimpleDateFormat("dd/MM/yyyy").parse(persona.getFechaNac());  
		personaGuardar.setTipoDoc(TipoDocumento.valueOf(persona.getTipoDoc()));
		personaGuardar.setDocumento(persona.getDocumento());
		personaGuardar.setNombre(persona.getNombre());
		personaGuardar.setApellido(persona.getApellido());
		personaGuardar.setFechaNac(fechaNac);
		personaGuardar.setDireccion(persona.getDireccion());
		servicioPersona.guardarOActualizar(personaGuardar);
		
		alumnoGuardar.setIdPersonaAlumno(personaGuardar);
		servicioAlumno.guardarOActualizar(alumnoGuardar);
		
		LOG.info("El alumno ha "+info+" correctamente");
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/borrar/{alumnoId}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarAlumno(@PathVariable Long alumnoId) throws NotFoundException {
		servicioAlumno.eliminarAlumno(alumnoId);
		
		LOG.info("El alumno ha sido eliminado correctamente");
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(path="/datosacademicos/{alumnoId}",method=RequestMethod.GET)
	public ResponseEntity<List<CarreraCursosDTO>> obtenerEstadoAcademico(@PathVariable Long alumnoId) {
		
		List<CarreraCursosDTO> carrerasYCurso = new ArrayList<CarreraCursosDTO>();
		
		Alumno alumno = servicioAlumno.obtenerAlumnoPorId(alumnoId);
		if(alumno == null) {
			LOG.info("No se encontro alumno con id: "+alumnoId);
			return ResponseEntity.notFound().build();
		}
		
		List<InscripcionesCarrera> carrerasInscriptas = alumno.getInscripcionesCarrera();
		
		for(InscripcionesCarrera carrera : carrerasInscriptas) {
			CarreraCursosDTO carreraCursosDto = new CarreraCursosDTO();
			if(carrera.getIdCarrera() != null) {
				carreraCursosDto.setNombreCarrera(carrera.getIdCarrera().getNombre());
				List<InscripcionesCurso> cursosActivos = new ArrayList<InscripcionesCurso>();
				List<InscripcionesCurso> cursosAprobados = new ArrayList<InscripcionesCurso>();
				List<InscripcionesCurso> cursosDesaprobados = new ArrayList<InscripcionesCurso>();
				BigDecimal contadorPromedio = new BigDecimal(0);
				for(InscripcionesCurso curso : alumno.getInscripcionesCurso()) {
					if(curso.getIdCurso() != null && curso.getIdCurso().getIdCarrera() != null 
							&& curso.getIdCurso().getIdCarrera().getNombre().equals(carrera.getIdCarrera().getNombre())) {
						if(curso.getFechaFinalizacion() == null) {
							cursosActivos.add(curso);
						} else 
							if (curso.getNotaFinal().compareTo(new BigDecimal(6)) >= 0 ) {
								cursosAprobados.add(curso);
								contadorPromedio.add(curso.getNotaFinal());
							}else {
								cursosDesaprobados.add(curso);
						}
					}
				}
				carreraCursosDto.setCursosActivos(cursosActivos);
				carreraCursosDto.setCursosAprobados(cursosAprobados);
				carreraCursosDto.setCursosDesaprobados(cursosDesaprobados);
				if(!cursosAprobados.isEmpty()) {
					carreraCursosDto.setPromedioGeneralCarrera(contadorPromedio.divide(new BigDecimal(cursosAprobados.size())));
				}
			}
			carrerasYCurso.add(carreraCursosDto);
		}
		
		LOG.info("Datos obtenidos correctamente");
		return new ResponseEntity<List<CarreraCursosDTO>>(carrerasYCurso, HttpStatus.OK);
	}
	
	@RequestMapping(path="/inscribiralumnoacarrera/{alumnoId}/{cursoId}",method=RequestMethod.GET)
	public ResponseEntity<Void> inscribirACurso(@PathVariable Long alumnoId, @PathVariable Long cursoId) {
		
		Alumno alumno = servicioAlumno.obtenerAlumnoPorId(alumnoId);
		Curso curso = servicioCurso.buscarCursoPorId(cursoId);
		if(alumno == null || curso == null) {
			LOG.info("No se encontro alumno con id: "+alumnoId+" o no se ecnontro curso con id: "+cursoId);
			return ResponseEntity.notFound().build();
		}
		
		InscripcionesCurso ic = servicioInscripcionesCurso.buscarInscripcionDeAlumnoACurso(alumno, curso);
		
		InscripcionesCurso inscripcion = new InscripcionesCurso();
		if(ic != null) {
			inscripcion = ic;
		}
		
		inscripcion.setFechaInscripcion(new Date());
		inscripcion.setIdAlumno(alumno);
		inscripcion.setIdCurso(curso);
		
		LOG.info("Alumno inscripto a la carrera correctamente");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}

