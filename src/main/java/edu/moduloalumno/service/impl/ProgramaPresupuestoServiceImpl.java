package edu.moduloalumno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.IProgramaPresupuestoDao;
import edu.moduloalumno.entity.ProgramaPresupuesto;
import edu.moduloalumno.service.IProgramaPresupuestoService;

@Service
public class ProgramaPresupuestoServiceImpl implements IProgramaPresupuestoService{

	@Autowired
	private IProgramaPresupuestoDao programaPresupuestoDao;
	
	@Override
	public List<ProgramaPresupuesto> listarPrograma(String codigo) {
		
		return programaPresupuestoDao.listarPrograma(codigo);
	}

}
