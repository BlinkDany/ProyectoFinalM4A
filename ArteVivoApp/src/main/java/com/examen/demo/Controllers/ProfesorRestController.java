package com.examen.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	// listar profesores
	@GetMapping("/profesores")
	public List<Profesor> indext() {
		return profesorService.findAll();
	}

	// Buscar profesor por Id
	@GetMapping("/profesores/{cod_profesor_pk}")
	public Profesor show(@PathVariable Long cod_profesor_pk) {
		return profesorService.findById(cod_profesor_pk);
	}

	// guardar profesores
	@PostMapping("/profesores")
	@ResponseStatus(HttpStatus.CREATED)
	public Profesor create(@RequestBody Profesor profesor) {

		return profesorService.save(profesor);
	}

	// Modificar Profesores
	@PutMapping("/profesores/{cod_profesor_pk}")
	@ResponseStatus(HttpStatus.CREATED)
	public Profesor update(@RequestBody Profesor profesor, @PathVariable Long cod_profesor_pk) {

		Profesor profeActual = profesorService.findById(cod_profesor_pk);

		profeActual.setCedula_profesor_fk(profesor.getCedula_profesor_fk());
		profeActual.setTitulo(profesor.getTitulo());

		return profesorService.save(profeActual);
	}

}
