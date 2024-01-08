package com.examen.demo.models.Service;

import java.util.List;

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

}
