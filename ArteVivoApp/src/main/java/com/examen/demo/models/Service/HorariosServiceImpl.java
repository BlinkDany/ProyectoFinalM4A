package com.examen.demo.models.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.demo.models.Dao.IHorariosDao;
import com.examen.demo.models.Entity.Horarios;

@Service
public class HorariosServiceImpl implements IHorariosService{

	@Autowired
	IHorariosDao horariosDao;
	
	@Override
	public List<Horarios> BuscarTodo() {
		// TODO Auto-generated method stub
		return (List<Horarios>) horariosDao.findAll();
	}

	@Override
	public Horarios guardar(Horarios horarios) {
		// TODO Auto-generated method stub
		return horariosDao.save(horarios);
	}

	@Override
	public Horarios BuscarPorId(Long codigoHorarios) {
		// TODO Auto-generated method stub
		return horariosDao.findById(codigoHorarios).orElse(null);
	}

	@Override
	public void eliminar(Long codigoHorarios) {
		// TODO Auto-generated method stub
		horariosDao.deleteById(codigoHorarios);
	}

}
