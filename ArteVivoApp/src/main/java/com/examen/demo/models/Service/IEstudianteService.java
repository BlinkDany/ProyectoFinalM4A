package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Estudiante;

public interface IEstudianteService {
	
	public List <Estudiante> findAll();
	
	public Estudiante save(Estudiante estudiante);
	
	public Estudiante findById(Long cod_estudiante_pk);
	
	public void delete(Long cod_estudiante_pk);
	
}
