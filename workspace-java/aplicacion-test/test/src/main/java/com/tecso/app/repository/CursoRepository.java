package com.tecso.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.tecso.app.model.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {
	
	
}
