package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Horarios;

public interface IHorariosService {

	public List<Horarios> BuscarTodo();
	
	public Horarios guardar(Horarios horarios);
	
	public Horarios BuscarPorId(Long codigoHorarios);
	
	public void eliminar(Long codigoHorarios);
}
