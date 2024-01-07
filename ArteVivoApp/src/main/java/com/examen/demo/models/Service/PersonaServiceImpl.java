package com.examen.demo.models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.demo.models.Dao.IPersonaDao;
import com.examen.demo.models.Entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	IPersonaDao personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		return personaDao.save(persona);
	}

	@Override
	public Persona findById(String cedula) {
		// TODO Auto-generated method stub
		return personaDao.findById(cedula).orElse(null);
	}

	@Override
	public void delete(String cedula) {
		// TODO Auto-generated method stub
		personaDao.deleteById(cedula);
	}

}