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

import com.examen.demo.models.Entity.Asignatura;
import com.examen.demo.models.Service.IAsignaturaService;



@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AsignaturaRestController {

	@Autowired
	private IAsignaturaService asignaturaService;
	
	@GetMapping("/asignatura")
	public List<Asignatura> index(){
		return asignaturaService.findAll();
		
	}
	    @GetMapping("/asignatura/{idAsignatura}")
	    public Asignatura show(@PathVariable Long idAsignatura) {
	    	return asignaturaService.findById(idAsignatura);
	    }
	    
	    @PostMapping("/asignatura")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Asignatura create(@RequestBody Asignatura asignatura) {
	    	return asignaturaService.save(asignatura);
	    }
	    
	    @PutMapping("/asignatura/{idAsignatura}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Asignatura update(@RequestBody Asignatura asignatura, @PathVariable Long idAsignatura) {
	    	Asignatura asignaturaActual = asignaturaService.findById(idAsignatura);
	    	asignaturaActual.setNombre(asignatura.getNombre());
	    	asignaturaActual.setDescripcion(asignatura.getDescripcion());
	    	return asignaturaService.save(asignaturaActual);
	    }
	    
	    @DeleteMapping("/asignatura/{idAsignatura}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void delete(@PathVariable Long idAsignatura) {
	    	asignaturaService.delete(idAsignatura);
	    }
	    @GetMapping("/matriculas/asignatura")
	    public ResponseEntity<List<Asignatura>> getAsignaturas() {
	        try {
	            List<Asignatura> asignaturas = asignaturaService.findAll();
	            return new ResponseEntity<>(asignaturas, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
