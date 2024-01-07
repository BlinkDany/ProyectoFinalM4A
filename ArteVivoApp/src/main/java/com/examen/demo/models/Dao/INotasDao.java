package com.examen.demo.models.Dao;

import org.springframework.data.repository.CrudRepository;

import com.examen.demo.models.Entity.Notas;

public interface INotasDao extends CrudRepository<Notas,Long> {

}
