package edu.moduloalumno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.IImporteAlumnoObligacionesDAO;
import edu.moduloalumno.entity.ImporteAlumnoObligaciones;
import edu.moduloalumno.service.IImporteAlumnoObligacionesService;
@Service
public class ImporteAlumnoObligacionesServiceImpl implements IImporteAlumnoObligacionesService{
    	@Autowired
    private IImporteAlumnoObligacionesDAO ImporteAlumnoObligacionesDAO;
	
	@Override
	public List<ImporteAlumnoObligaciones> getAllImporteAlumnosObligaciones() {
		return ImporteAlumnoObligacionesDAO.getAllImporteAlumnosObligaciones();
	}
	
	@Override
	public List<ImporteAlumnoObligaciones> getImporteAlumnoObligacionesImporte(int cod_alumno, int cod_programa) {
		return ImporteAlumnoObligacionesDAO.getImporteAlumnoObligacionesImporte(cod_alumno, cod_programa);
	}
	
	@Override
	public synchronized void addImporteAlumnoObligaciones(ImporteAlumnoObligaciones importealumnoobligaciones) {
		ImporteAlumnoObligacionesDAO.addImporteAlumnoObligaciones(importealumnoobligaciones);
	
	}
	
	@Override
	public void updateImporteAlumnoObligaciones(ImporteAlumnoObligaciones importealumnoobligaciones) {
		ImporteAlumnoObligacionesDAO.updateImporteAlumnoObligaciones(importealumnoobligaciones);
	}
	
	@Override
	public void deleteImporteAlumnoObligaciones(int id_importealumnoobligaciones) {
		ImporteAlumnoObligacionesDAO.deleteImporteAlumnoObligaciones(id_importealumnoobligaciones);
	}
	
}
