package com.examen.demo.models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.demo.models.Dao.IAsignaturaDao;
import com.examen.demo.models.Entity.Asignatura;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService{
	
	@Autowired
	private IAsignaturaDao asignaturaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> findAll() {
		// TODO Auto-generated method stub
		return (List<Asignatura>)asignaturaDao.findAll();
	}

	@Override
	@Transactional
	public Asignatura save(Asignatura asignatura) {
		// TODO Auto-generated method stub
		return asignaturaDao.save(asignatura);
	}

	@Override
	@Transactional(readOnly = true)
	public Asignatura findById(Long id) {
		// TODO Auto-generated method stub
		return asignaturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		asignaturaDao.deleteById(id);;
	}

}
