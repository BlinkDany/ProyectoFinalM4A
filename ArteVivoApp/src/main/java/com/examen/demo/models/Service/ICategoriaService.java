package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Categoria;


public interface ICategoriaService {
	public List<Categoria> findAll();

	public Categoria save(Categoria categoria);

	public Categoria findById(Long id);

	public void delete (Long id);

}
