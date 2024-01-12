package com.examen.demo.models.Dao;

import org.springframework.data.repository.CrudRepository;

import com.examen.demo.models.Entity.Tareas;

public interface ITareasDao extends CrudRepository<Tareas,Long> {

}