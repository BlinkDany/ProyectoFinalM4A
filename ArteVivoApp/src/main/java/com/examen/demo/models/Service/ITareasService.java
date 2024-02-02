package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Tareas;

public interface ITareasService {
	public List<Tareas> findAll();

	public Tareas save(Tareas tareas);
	
	public Tareas findById(Long codigoTareas);

	public void delete (Long codigoTareas);
	
	public List<Tareas> findByAsignaturaId(Long idAsignatura);

}
