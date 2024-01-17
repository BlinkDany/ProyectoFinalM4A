package com.examen.demo.models.Dao;

import org.springframework.data.repository.CrudRepository;

import com.examen.demo.models.Entity.Estudiante;

public interface IEstudianteDao extends CrudRepository<Estudiante, String> {

}
