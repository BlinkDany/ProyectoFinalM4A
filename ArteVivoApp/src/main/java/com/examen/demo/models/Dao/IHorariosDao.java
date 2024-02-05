package com.examen.demo.models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.examen.demo.models.Entity.Horarios;

public interface IHorariosDao extends CrudRepository<Horarios, Long>{
	
	@Query(value="SELECT h FROM horarios h JOIN asignatura a ON h.codigo_asignatura = a.id_asignatura JOIN matriculas m ON a.id_asignatura = m.codigo_asignatura JOIN estudiantes e ON m.ced_estudiante_fk = e.cedula WHERE e.cedula =  :ced_estudiante_fk",nativeQuery = true)
    List<Horarios> getHorariosPorEstudiante(@Param("ced_estudiante_fk") String ced_estudiante_fk);
	
	@Query(value="SELECT h.dia,h.hora_inicio,h.hora_fin FROM horarios h JOIN asignatura a ON h.codigo_asignatura = a.id_asignatura JOIN matriculas m ON a.id_asignatura = m.codigo_asignatura JOIN estudiantes e ON m.ced_estudiante_fk = e.cedula WHERE e.cedula =  :ced_estudiante_fk",nativeQuery = true)
    List<String> getHorariosPorEstudiante2(@Param("ced_estudiante_fk") String ced_estudiante_fk);
}
