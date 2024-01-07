package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Notas;

public interface INotasService {
	public List<Notas> findAll();

	public Notas save(Notas notas);

	public Notas findById(Long id);

	public void delete (Long id);

}
