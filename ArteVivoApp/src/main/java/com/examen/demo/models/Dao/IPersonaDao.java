package com.examen.demo.models.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.examen.demo.models.Entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, String>{
	
	Optional<Persona> findByCedula(String cedula);
	
	Optional<Persona> findByCorreo(String correo);
	
	List<Persona> findByNombresContainingIgnoreCase(String nombres);
	
    List<Persona> findByApellidosContainingIgnoreCase(String apellidos);

}
