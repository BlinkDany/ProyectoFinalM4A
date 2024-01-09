package com.examen.demo.models.Dao;

import org.springframework.data.repository.CrudRepository;

import com.examen.demo.models.Entity.Profesor;

public interface IProfesorDao extends CrudRepository<Profesor, Long> {

}
