package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Persona;

public interface IPersonaService{

	public List<Persona> findAll();
	
	public Persona save(Persona persona);
	
	public Persona findById(String cedula);
	
	public void delete(String cedula);
	
	public Persona authenticate(String correo, String contrasena);
	
	String getTipoUsuario(String cedula);
	
}
