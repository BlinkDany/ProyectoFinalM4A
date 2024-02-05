package com.examen.demo.models.Service;

import java.util.List;

import com.examen.demo.models.Entity.Horarios;

public interface IHorariosService {

	public List<Horarios> BuscarTodo();
	
	public Horarios guardar(Horarios horarios);
	
	public Horarios BuscarPorId(Long codigoHorarios);
	
	public void eliminar(Long codigoHorarios);
	
	List<Horarios> getHorariosPorEstudiante(String ced_estudiante_fk);
	
	List<String> getHorariosPorEstudiante2(String ced_estudiante_fk);
}
