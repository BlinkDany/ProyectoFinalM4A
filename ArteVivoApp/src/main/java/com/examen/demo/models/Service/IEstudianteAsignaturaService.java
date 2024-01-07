package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.EstudianteAsignatura;

public interface IEstudianteAsignaturaService {

	public List<EstudianteAsignatura> findAll();
	
	public EstudianteAsignatura save (EstudianteAsignatura estudianteAsignatura);
	
	public EstudianteAsignatura findById(Long codigoEstAsig);
	
	public void delete(Long codigoEstAsig);
}
