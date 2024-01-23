package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Matricula;

public interface IMatriculaService {
	
	public List <Matricula> findAll();
	
	public Matricula save(Matricula matricula);
	
	public Matricula findById(Long cod_matricula_pk);
	
	public void delete(Long cod_matricula_pk);
	List<Matricula> getMatriculasByEstudiante(String ced_estudiante_fk);

}
