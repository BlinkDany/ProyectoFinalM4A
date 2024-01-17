package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Estudiante;

public interface IEstudianteService {
	
	public List <Estudiante> findAll();
	
	public Estudiante save(Estudiante estudiante);
	
	public Estudiante findById(String cedula);
	
	public void delete(String cedula);
	
}
