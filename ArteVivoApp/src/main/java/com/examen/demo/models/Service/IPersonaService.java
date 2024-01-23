package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Persona;

public interface IPersonaService extends UserDetailsService{

	public List<Persona> findAll();
	
	public Persona save(Persona persona);
	
	public Persona findById(String cedula);
	
	public void delete(String cedula);
	
	public UserDetails loadUserByUsername(String username);
}
