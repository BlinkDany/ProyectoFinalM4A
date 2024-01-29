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
	@GetMapping("/estudiantes/{cedula}")
	public Estudiante show(@PathVariable String cedula) {
		return estudianteService.findById(cedula);
	}

	// guardar
	@PostMapping("/estudiantes")
	@ResponseStatus(HttpStatus.CREATED)
	public Estudiante create(@RequestBody Estudiante estudiante) {

		return estudianteService.save(estudiante);
	}

	// modificar
	@PutMapping("/estudiantes/{cedula}")
	@ResponseStatus(HttpStatus.CREATED)
	public Estudiante update(@RequestBody Estudiante estudiante, @PathVariable String cedula) {

		Estudiante estuActual = estudianteService.findById(cedula);

		estuActual.setCedula_estudiante_fk(estudiante.getCedula_estudiante_fk());
		estuActual.setNombres(estudiante.getNombres());
		estuActual.setApellidos(estudiante.getApellidos());
		estuActual.setDireccion(estudiante.getDireccion());

		return estudianteService.save(estuActual);
	}

	// eliminar
	@DeleteMapping("/estudiantes/{cedula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String cedula) {
		estudianteService.delete(cedula);
	}

}
