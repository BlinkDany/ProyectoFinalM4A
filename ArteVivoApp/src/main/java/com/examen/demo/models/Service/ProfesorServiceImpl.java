package com.examen.demo.models.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.examen.demo.models.Dao.IProfesorDao;
import com.examen.demo.models.Entity.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	private IProfesorDao profesorDao;

	@Override
	@Transactional(readOnly = true)
	public List<Profesor> findAll() {
		// TODO Auto-generated method stub
		return (List<Profesor>) profesorDao.findAll();
	}

	@Override
	@Transactional
	public Profesor save(Profesor profesor) {
		// TODO Auto-generated method stub
		return profesorDao.save(profesor);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findById(Long cod_profesor_pk) {
		// TODO Auto-generated method stub
		return profesorDao.findById(cod_profesor_pk).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long cod_profesor_pk) {
		// TODO Auto-generated method stub
		profesorDao.deleteById(cod_profesor_pk);
	}

}
