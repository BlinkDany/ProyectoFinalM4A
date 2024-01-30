package com.examen.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.examen.demo.models.Entity.Profesor;
import com.examen.demo.models.Service.IProfesorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProfesorRestController {

	@Autowired
	private IProfesorService profesorService;

	@GetMapping("/profesores")
	public List<Profesor> indext() {
		return profesorService.findAll();
	}

	@GetMapping("/profesores/{cedula}")
	public Profesor show(@PathVariable String cedula) {
		return profesorService.findById(cedula);
	}

	@PostMapping("/profesores")
	@ResponseStatus(HttpStatus.CREATED)
	public Profesor create(@RequestBody Profesor profesor) {

		return profesorService.save(profesor);
	}

	@PutMapping("/profesores/{cedula}")
	@ResponseStatus(HttpStatus.CREATED)
	public Profesor update(@RequestBody Profesor profesor, @PathVariable String cedula) {

		Profesor profeActual = profesorService.findById(cedula);

		profeActual.setTitulo(profesor.getTitulo());
		profeActual.setApellidos(profesor.getApellidos());
		profeActual.setNombres(profesor.getNombres());
		profeActual.setDireccion(profesor.getDireccion());
		profeActual.setCorreo(profesor.getCorreo());
		profeActual.setContrasena(profesor.getContrasena());
		profeActual.setTelf(profesor.getTelf());
		profeActual.setFecha_nac(profesor.getFecha_nac());
		profeActual.setFoto(profesor.getFoto());

		return profesorService.save(profeActual);
	}
	// eliminar
	@DeleteMapping("/profesores/{cedula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String cedula) {
		profesorService.delete(cedula);
	}

}
