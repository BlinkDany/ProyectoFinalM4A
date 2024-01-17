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

import com.examen.demo.models.Entity.EstudianteAsignatura;
import com.examen.demo.models.Service.IEstudianteAsignaturaService;

@RestController
@RequestMapping("/api")
public class EstudianteAsignaturaRestController {

	@Autowired IEstudianteAsignaturaService eAsignaturaService;
	
	//LISTAR
	@GetMapping("/estudianteAsignatura")
	public List<EstudianteAsignatura> mostar(){
		
		return eAsignaturaService.findAll();
	}
	
	//CREAR
	@PostMapping("/estudianteAsignatura")
	@ResponseStatus(HttpStatus.CREATED)
	public EstudianteAsignatura registrar (@RequestBody EstudianteAsignatura estudianteAsignatura) {
		
		return eAsignaturaService.save(estudianteAsignatura);
	}
	
	//BUSCAR
	@GetMapping("/estudianteAsignatura{codigoEstAsig}")
	public EstudianteAsignatura buscar(@PathVariable Long codigoEstAsig) {
		
		return eAsignaturaService.findById(codigoEstAsig);
	}
	
	//ACTUALIZAR
	@PutMapping("/estudianteAsignatura/{codigoEstAsig}")
	@ResponseStatus(HttpStatus.CREATED)
	public EstudianteAsignatura actualizar(@RequestBody EstudianteAsignatura estudianteAsignatura, @PathVariable Long codigoEstAsig) {
		
		EstudianteAsignatura estudianteAsignatura2 = eAsignaturaService.findById(codigoEstAsig);
		estudianteAsignatura2.setAsistencias(estudianteAsignatura.getAsistencias());
		estudianteAsignatura2.setCalificacion(estudianteAsignatura.getCalificacion());
		estudianteAsignatura2.setCodigoAsignatura(estudianteAsignatura.getCodigoAsignatura());
		estudianteAsignatura2.setCed_estudiante_fk(estudianteAsignatura.getCed_estudiante_fk());
		estudianteAsignatura2.setEstado(estudianteAsignatura.getEstado());
		
		return eAsignaturaService.save(estudianteAsignatura2);
	}
	
	//DELETE
	@DeleteMapping("/estudianteAsignatura/{codigoEstAsig}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long codigoEstAsig) {
		
		eAsignaturaService.delete(codigoEstAsig);
	}
}
