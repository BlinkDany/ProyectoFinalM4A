package com.examen.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examen.demo.models.Entity.Persona;
import com.examen.demo.models.Service.IPersonaService;

@RestController
@RequestMapping("/api")
public class PersonaRestController {

	@Autowired
	private IPersonaService personaService;
	
	//LISTAR
	@GetMapping("/persona")
	public List<Persona> index(){
		
		return personaService.findAll();
	}
	
	//CREAR
	@PostMapping("/persona")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona create(@RequestBody Persona persona) {
		
		return personaService.save(persona);
	}
	
	//BUSCARPERSONA
	@GetMapping("/persona/{cedula}")
	public Persona show(@PathVariable String cedula) {
		
		return personaService.findById(cedula);
	}
	
	//ACTUALIZAR
	@PutMapping("/persona/{cedula}")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona update(@PathVariable String cedula, @RequestBody Persona persona) {
		
		Persona personaActual = personaService.findById(cedula);
		personaActual.setApellidos(persona.getApellidos());
		personaActual.setCorreo(persona.getCorreo());
		personaActual.setDireccion(persona.getDireccion());
		personaActual.setFecha_nac(persona.getFecha_nac());
		personaActual.setNombres(persona.getNombres());
		personaActual.setTelf(persona.getTelf());
		
		return personaService.save(personaActual);
	}
	
	//ELIMINAR
	@DeleteMapping("/persona/{cedula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String cedula) {
		
		personaService.delete(cedula);
	}
}
