package com.examen.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examen.demo.models.Entity.Horarios;
import com.examen.demo.models.Service.IHorariosService;

@RestController
@RequestMapping("/api")
public class HorariosRestController {

	@Autowired
	IHorariosService horariosService;
	
	//CREAR
	@PostMapping("/horarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Horarios crear(@RequestBody Horarios horarios) {
		
		return horariosService.guardar(horarios);
	}
	
	//LISTAR
	@GetMapping("/horarios")
	public List<Horarios> mostrar(){
		
		return horariosService.BuscarTodo();
	}
	
	//BUSCAR
	@GetMapping("/horarios/{codigoHorarios}")
	public Horarios buscar(@PathVariable Long codigoHorarios) {
		
		return horariosService.BuscarPorId(codigoHorarios);
	}
	
	//ACTUALIZAR
	@PutMapping("/horarios7{codigoHorarios}")
	@ResponseStatus(HttpStatus.CREATED)
	public Horarios actualizar(@RequestBody Horarios horarios, @PathVariable Long codigoHorarios) {
		
		Horarios horarioActual = horariosService.BuscarPorId(codigoHorarios);
		horarioActual.setHora_fin(horarios.getHora_fin());
		horarioActual.setHora_Inicio(horarios.getHora_Inicio());
		
		return horariosService.guardar(horarioActual);
	}
	
	//ELIMINAR
	public void eliminar(@PathVariable Long codigoHorarios) {
		
		horariosService.eliminar(codigoHorarios);
	}
	
	
	
}
