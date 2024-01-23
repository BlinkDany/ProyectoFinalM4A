package com.examen.demo.models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.examen.demo.models.Entity.Matricula;

public interface IMatriculaDao extends CrudRepository<Matricula, Long>{

	 // Otra consulta personalizada para obtener matrículas por cédula de estudiante
    @Query("SELECT m FROM Matricula m WHERE m.ced_estudiante_fk = :ced_estudiante_fk")
    List<Matricula> findByCedEstudianteFk(@Param("ced_estudiante_fk") String cedulaEstudiante);
}
