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

import com.examen.demo.models.Entity.Tareas;
import com.examen.demo.models.Service.ITareasService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class TareasRestController {

	@Autowired
	private ITareasService tareasService;

	@GetMapping("/tareas")
	public List<Tareas> indext() {
		return tareasService.findAll();

	}
	
    @GetMapping("/tareas/{id}")
    public Tareas show(@PathVariable Long id) {
    	return tareasService.findById(id);
    }
    
    @PostMapping("/tareas")
    @ResponseStatus(HttpStatus.CREATED)
    public Tareas create(@RequestBody Tareas notas) {
    	return tareasService.save(notas);
    }
    
    @PutMapping("/tareas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tareas update(@RequestBody Tareas tareas, @PathVariable Long id) {
    	Tareas notaactual = tareasService.findById(id);
    	notaactual.setObservaciones(tareas.getObservaciones());
    	notaactual.setFecharegistro(tareas.getFecharegistro());
    	return tareasService.save(notaactual);
    }
    
    @DeleteMapping("/tareas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	tareasService.delete(id);
    }
    
    
}
