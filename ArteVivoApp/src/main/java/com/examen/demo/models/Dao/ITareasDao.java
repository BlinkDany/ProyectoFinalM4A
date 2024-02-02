package com.examen.demo.models.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.examen.demo.models.Entity.Tareas;

public interface ITareasDao extends CrudRepository<Tareas,Long> {

	List<Tareas> findByIdAsignatura(Long idAsignatura);

}