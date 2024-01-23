package com.examen.demo.models.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.examen.demo.models.Entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, String>{
	
	Optional<Persona> findByCedula(String cedula);

}
