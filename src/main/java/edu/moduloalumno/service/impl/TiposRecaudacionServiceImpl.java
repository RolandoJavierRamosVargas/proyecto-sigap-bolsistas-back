package edu.moduloalumno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.ITiposRecaudacionDAO;
import edu.moduloalumno.entity.TiposRecaudacion;
import edu.moduloalumno.service.ITiposRecaudacionService;

@Service
public class TiposRecaudacionServiceImpl implements ITiposRecaudacionService {

	@Autowired
	private ITiposRecaudacionDAO tiposRecaudacion;
	
	@Override
	public List<TiposRecaudacion> listar() {
		
		return tiposRecaudacion.listar();
	}

}
