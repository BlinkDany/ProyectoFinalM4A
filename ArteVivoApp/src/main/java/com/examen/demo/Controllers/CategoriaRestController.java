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

import com.examen.demo.models.Entity.Categoria;
import com.examen.demo.models.Service.ICategoriaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CategoriaRestController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@GetMapping("/categoria")
	public List<Categoria> indext(){
		return categoriaService.findAll();
		
	}
	    @GetMapping("/categoria/{id}")
	    public Categoria show(@PathVariable Long id) {
	    	return categoriaService.findById(id);
	    }
	    
	    @PostMapping("/categoria")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Categoria create(@RequestBody Categoria categoria) {
	    	return categoriaService.save(categoria);
	    }
	    
	    @PutMapping("/categoria/{id}")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Categoria update(@RequestBody Categoria categoria, @PathVariable Long id) {
	    	Categoria categoriaactual = categoriaService.findById(id);
	    	categoriaactual.setDescripcion(categoria.getDescripcion());
	    	categoriaactual.setNombre(categoria.getNombre());
	    	return categoriaService.save(categoriaactual);
	    }
	    
	    @DeleteMapping("/categoria/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void delete(@PathVariable Long id) {
	    	categoriaService.delete(id);
	    }
}
