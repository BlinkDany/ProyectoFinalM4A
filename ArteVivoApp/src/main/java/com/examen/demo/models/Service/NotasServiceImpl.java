package com.examen.demo.models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.demo.models.Dao.INotasDao;
import com.examen.demo.models.Entity.Notas;

@Service
public class NotasServiceImpl implements INotasService{

	
	@Autowired
	private INotasDao NotasDao;

	@Override
	@Transactional(readOnly = true)
	public List<Notas> findAll() {
		return (List<Notas>) NotasDao.findAll();
	}

	@Override
	@Transactional
	public Notas save(Notas notas) {
		// TODO Auto-generated method stub
		return NotasDao.save(notas);
	}

	@Override
	@Transactional(readOnly = true)
	public Notas findById(Long id) {
		// TODO Auto-generated method stub
		return NotasDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		NotasDao.deleteById(id);
		
	}

}
