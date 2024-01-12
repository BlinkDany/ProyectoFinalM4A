package com.examen.demo.models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.demo.models.Dao.ITareasDao;
import com.examen.demo.models.Entity.Tareas;

@Service
public class TareasServiceImpl implements ITareasService{

	
	@Autowired
	private ITareasDao TareaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Tareas> findAll() {
		return (List<Tareas>) TareaDao.findAll();
	}

	@Override
	@Transactional
	public Tareas save(Tareas notas) {
		// TODO Auto-generated method stub
		return TareaDao.save(notas);
	}

	@Override
	@Transactional(readOnly = true)
	public Tareas findById(Long id) {
		// TODO Auto-generated method stub
		return TareaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		TareaDao.deleteById(id);
		
	}

}
