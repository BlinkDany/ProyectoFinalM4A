package com.examen.demo.models.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.examen.demo.models.Entity.Matricula;

public interface IMatriculaDao extends CrudRepository<Matricula, Long> {

    // Otra consulta personalizada para obtener matrículas por cédula de estudiante
    @Query("SELECT m FROM Matricula m WHERE m.ced_estudiante_fk = :ced_estudiante_fk")
    List<Matricula> findByCedEstudianteFk(@Param("ced_estudiante_fk") String cedulaEstudiante);

    @Query("SELECT m FROM Matricula m WHERE m.codigoAsignatura = :idAsignatura")
    List<Matricula> findByAsignaturaId(@Param("idAsignatura") Long idAsignatura);

    @Query("SELECT m.horario FROM Matricula m WHERE m.ced_estudiante_fk = :ced_estudiante_fk")
    List<String> getHorarioPorEstudiante(@Param("ced_estudiante_fk") String ced_estudiante_fk);
    
    @Query("SELECT m FROM Matricula m WHERE m.asignatura.nombre = :nombreAsignatura")
    List<Matricula> findByAsignaturaNombre(@Param("nombreAsignatura") String nombreAsignatura);
}
