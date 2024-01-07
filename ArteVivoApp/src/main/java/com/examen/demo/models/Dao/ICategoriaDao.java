package com.examen.demo.models.Dao;

import org.springframework.data.repository.CrudRepository;

import com.examen.demo.models.Entity.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria,Long>{

}
