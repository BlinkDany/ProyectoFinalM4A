package com.examen.demo.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.examen.demo.models.Entity.Matricula;
import com.examen.demo.models.Service.IMatriculaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MatriculaRestController {

	@Autowired
	private IMatriculaService matriculaService;

	// lista
	@GetMapping("/matriculas")
	public List<Matricula> indext() {
		return matriculaService.findAll();
	}

	// busca
	@GetMapping("/matriculas/{cod_matricula_pk}")
	public Matricula show(@PathVariable Long cod_matricula_pk) {
		return matriculaService.findById(cod_matricula_pk);
	}

	// guarda
	@PostMapping("/matriculas")
	@ResponseStatus(HttpStatus.CREATED)
	public Matricula create(@RequestBody Matricula matricula) {

		return matriculaService.save(matricula);
	}

	// modificar
	@PutMapping("/matriculas/{cod_matricula_pk}")
	@ResponseStatus(HttpStatus.CREATED)
	public Matricula update(@RequestBody Matricula matricula, @PathVariable Long cod_matricula_pk) {

		Matricula matriActual = matriculaService.findById(cod_matricula_pk);

		matriActual.setFecha_ini(matricula.getFecha_ini());
		matriActual.setFeche_fin(matricula.getFeche_fin());

		return matriculaService.save(matriActual);
	}

	@DeleteMapping("/matriculas/{cod_matricula_pk}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long cod_matricula_pk) {
		matriculaService.delete(cod_matricula_pk);
	}

	@GetMapping("/matriculas/estudiante/{ced_estudiante_fk}")
	public ResponseEntity<List<Matricula>> getMatriculasByEstudiante(@PathVariable String ced_estudiante_fk) {
		try {
			// Implementa tu lógica para obtener matrículas por el código del estudiante
			List<Matricula> matriculas = matriculaService.getMatriculasByEstudiante(ced_estudiante_fk);

			// Puedes agregar lógica adicional aquí si es necesario

			return new ResponseEntity<>(matriculas, HttpStatus.OK);
		} catch (Exception e) {
			// Maneja las excepciones según tus necesidades
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
