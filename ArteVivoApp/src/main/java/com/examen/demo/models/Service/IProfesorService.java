package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Profesor;

public interface IProfesorService {

	public List<Profesor> findAll();

	public Profesor save(Profesor profesor);

	public Profesor findById(Long cod_profesor_pk);

	public void delete(Long cod_profesor_pk);
}
