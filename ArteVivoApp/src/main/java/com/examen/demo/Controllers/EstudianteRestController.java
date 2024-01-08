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
import com.examen.demo.models.Entity.Estudiante;
import com.examen.demo.models.Service.IEstudianteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EstudianteRestController {
	
	@Autowired
	private IEstudianteService estudianteService;

	// listar
	@GetMapping("/estudiantes")
	public List<Estudiante> indext() {
		return estudianteService.findAll();
	}

	// busca x id
	@GetMapping("/estudiantes/{cod_estudiante_pk}")
	public Estudiante show(@PathVariable Long cod_estudiante_pk) {
		return estudianteService.findById(cod_estudiante_pk);
	}

	// guardar
	@PostMapping("/estudiantes")
	@ResponseStatus(HttpStatus.CREATED)
	public Estudiante create(@RequestBody Estudiante estudiante) {

		return estudianteService.save(estudiante);
	}

	// modificar
	@PutMapping("/estudiantes/{cod_estudiante_pk}")
	@ResponseStatus(HttpStatus.CREATED)
	public Estudiante update(@RequestBody Estudiante estudiante, @PathVariable Long cod_estudiante_pk) {

		Estudiante estuActual = estudianteService.findById(cod_estudiante_pk);

		estuActual.setCedula_estudiante_fk(estudiante.getCedula_estudiante_fk());

		return estudianteService.save(estuActual);
	}

	// eliminar
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long cod_estudiante_pk) {
		estudianteService.delete(cod_estudiante_pk);
	}

}
