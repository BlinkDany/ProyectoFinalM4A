package com.examen.demo.models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.examen.demo.models.Dao.IEstudianteDao;
import com.examen.demo.models.Entity.Estudiante;

@Service
public class EstudianteServiceLmpl implements IEstudianteService{
	
	@Autowired
	IEstudianteDao estudianteDao;

	@Override
	@Transactional (readOnly = true)
	public List<Estudiante> findAll() {
		
		return (List<Estudiante>) estudianteDao.findAll();
	}

	@Override
	@Transactional
	public Estudiante save(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return estudianteDao.save(estudiante);
	}

	@Override
	@Transactional (readOnly = true)
	public Estudiante findById(String cedula) {
		// TODO Auto-generated method stub
		return estudianteDao.findById(cedula).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String cedula) {
		// TODO Auto-generated method stub
		estudianteDao.deleteById(cedula);
	}

}


