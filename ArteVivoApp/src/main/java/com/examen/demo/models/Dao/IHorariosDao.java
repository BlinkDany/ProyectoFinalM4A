package com.examen.demo.models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.examen.demo.models.Entity.Horarios;

public interface IHorariosDao extends CrudRepository<Horarios, Long>{
	
	@Query(value="SELECT h FROM Horarios h JOIN Asignatura a ON h.codigo_asignatura = a.id_asignatura JOIN Matriculas m ON a.id_asignatura = m.codigo_asignatura JOIN Estudiantes e ON m.ced_estudiante_fk = e.cedula WHERE e.cedula =  :ced_estudiante_fk;",nativeQuery = true)
    List<Horarios> getHorariosPorEstudiante(@Param("ced_estudiante_fk") String ced_estudiante_fk);
}
