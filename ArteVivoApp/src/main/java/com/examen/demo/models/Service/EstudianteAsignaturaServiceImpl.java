package com.examen.demo.models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.demo.models.Dao.IEstudianteAsignaturaDao;
import com.examen.demo.models.Entity.EstudianteAsignatura;

@Service
public class EstudianteAsignaturaServiceImpl implements IEstudianteAsignaturaService{

	@Autowired
	IEstudianteAsignaturaDao eAsignaturaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<EstudianteAsignatura> findAll() {
		// TODO Auto-generated method stub
		return (List<EstudianteAsignatura>) eAsignaturaDao.findAll();
	}

	@Override
	public EstudianteAsignatura save(EstudianteAsignatura estudianteAsignatura) {
		// TODO Auto-generated method stub
		return eAsignaturaDao.save(estudianteAsignatura);
	}

	@Override
	public EstudianteAsignatura findById(Long codigoEstAsig) {
		// TODO Auto-generated method stub
		return eAsignaturaDao.findById(codigoEstAsig).orElse(null);
	}

	@Override
	public void delete(Long codigoEstAsig) {
		// TODO Auto-generated method stub
		eAsignaturaDao.deleteById(codigoEstAsig);
	}

}
