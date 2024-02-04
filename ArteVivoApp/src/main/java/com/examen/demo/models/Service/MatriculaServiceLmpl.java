package com.examen.demo.models.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.demo.models.Dao.IMatriculaDao;
import com.examen.demo.models.Entity.Matricula;

@Service
public class MatriculaServiceLmpl implements IMatriculaService{
	
	@Autowired
	IMatriculaDao matriculaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Matricula> findAll() {
		// TODO Auto-generated method stub
		return (List<Matricula>) matriculaDao.findAll();
	}

	@Override
	@Transactional
	public Matricula save(Matricula matricula) {
		// TODO Auto-generated method stub
		return matriculaDao.save(matricula);
	}

	@Override
	@Transactional(readOnly = true)
	public Matricula findById(Long cod_matricula_pk) {
		// TODO Auto-generated method stub
		return matriculaDao.findById(cod_matricula_pk).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long cod_matricula_pk) {
		// TODO Auto-generated method stub
		matriculaDao.deleteById(cod_matricula_pk);
	}
	  @Override
	    public List<Matricula> getMatriculasByEstudiante(String ced_estudiante_fk) {
	        // Implementa la lógica para obtener matrículas por el código del estudiante
	        return matriculaDao.findByCedEstudianteFk(ced_estudiante_fk);
	    }

	  @Override
	    public List<Matricula> getMatriculasByAsignatura(Long idAsignatura) {
	        // Implementa la lógica para obtener matrículas por el ID de la asignatura
	        return matriculaDao.findByAsignaturaId(idAsignatura);
	    }

	  @Override
	    @Transactional(readOnly = true)
	    public List<String> getHorarioPorEstudiante(String ced_estudiante_fk) {
	        return matriculaDao.getHorarioPorEstudiante(ced_estudiante_fk);
	    }
	  
	  @Override
	  @Transactional(readOnly = true)
	  public List<Matricula> getNomMatriculasByAsignatura(Long idAsignatura) {
	      List<Matricula> matriculas = matriculaDao.findByAsignaturaId(idAsignatura);

	      // Cargar información de asignatura para cada matrícula
	      for (Matricula matricula : matriculas) {
	          matricula.getAsignatura(); // Esto carga la información de la asignatura para cada matrícula
	      }

	      return matriculas;
	  }

}
