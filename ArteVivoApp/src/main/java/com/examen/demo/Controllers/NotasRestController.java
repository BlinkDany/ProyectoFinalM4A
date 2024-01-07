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

import com.examen.demo.models.Entity.Notas;
import com.examen.demo.models.Service.INotasService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class NotasRestController {

	@Autowired
	private INotasService notasService;

	@GetMapping("/notas")
	public List<Notas> indext() {
		return notasService.findAll();

	}
	
    @GetMapping("/notas/{id}")
    public Notas show(@PathVariable Long id) {
    	return notasService.findById(id);
    }
    
    @PostMapping("/notas")
    @ResponseStatus(HttpStatus.CREATED)
    public Notas create(@RequestBody Notas notas) {
    	return notasService.save(notas);
    }
    
    @PutMapping("/notas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Notas update(@RequestBody Notas notas, @PathVariable Long id) {
    	Notas notaactual = notasService.findById(id);
    	notaactual.setObservaciones(notas.getObservaciones());
    	notaactual.setFecharegistro(notas.getFecharegistro());
    	return notasService.save(notaactual);
    }
    
    @DeleteMapping("/notas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	notasService.delete(id);
    }
    
    
}
