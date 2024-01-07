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
	    @GetMapping("/asignatura/{id}")
	    public Asignatura show(@PathVariable Long id) {
	    	return asignaturaService.findById(id);
	    }
	    
	    @PostMapping("/asignatura")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Asignatura create(@RequestBody Asignatura asignatura) {
	    	return asignaturaService.save(asignatura);
	    }
	    
	    @PutMapping("/asignatura/{id}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Asignatura update(@RequestBody Asignatura asignatura, @PathVariable Long id) {
	    	Asignatura asignaturaActual = asignaturaService.findById(id);
	    	asignaturaActual.setNombre(asignatura.getNombre());
	    	asignaturaActual.setDescripcion(asignatura.getDescripcion());
	    	return asignaturaService.save(asignaturaActual);
	    }
	    
	    @DeleteMapping("/asignatura/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void delete(@PathVariable Long id) {
	    	asignaturaService.delete(id);
	    }
}
