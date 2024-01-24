package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Asignatura;

public interface IAsignaturaService {
	public List<Asignatura> findAll();
	
	public Asignatura save(Asignatura asignatura);
	
	public Asignatura findById(Long idAsignatura);
	
	public void delete(Long idAsignatura);
}
