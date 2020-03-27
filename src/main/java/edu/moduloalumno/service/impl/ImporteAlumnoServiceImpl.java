package edu.moduloalumno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.IImporteAlumnoDAO;
import edu.moduloalumno.entity.ImporteAlumno;
import edu.moduloalumno.service.IImporteAlumnoService;
@Service
public class ImporteAlumnoServiceImpl implements IImporteAlumnoService{
        @Autowired
	private IImporteAlumnoDAO ImporteAlumnoDAO;
    
	@Override
	public ImporteAlumno getImporteAlumnoByAlumnoId(int cod_alumno) {
		ImporteAlumno ImporteAlumno = ImporteAlumnoDAO.getImporteAlumnoByAlumnoId(cod_alumno);
		return ImporteAlumno;
	}
	
	@Override
	public ImporteAlumno getImporteAlumnoImporte(String cod_alumno, int cod_programa, int cod_concepto,Integer id_tipo_recaudacion) {
		ImporteAlumno ImporteAlumno = ImporteAlumnoDAO.getImporteAlumnoImporte(cod_alumno,cod_programa,cod_concepto,id_tipo_recaudacion);
		return ImporteAlumno;
	}
	
	@Override
	public double getImporteAlumno(ImporteAlumno importealumno) {
		System.out.println("LLEGA HASTA SERVICEIMP");
		double importe = ImporteAlumnoDAO.getImporteAlumno(importealumno);
		return importe;
	}

	@Override
	public List<ImporteAlumno> getAllImporteAlumnos() {
		return ImporteAlumnoDAO.getAllImporteAlumnos();
	}

	@Override
	public synchronized void addImporteAlumno(ImporteAlumno importealumno) {
		ImporteAlumnoDAO.addImporteAlumno(importealumno);

	}

	@Override
	public void updateImporteAlumno(ImporteAlumno importealumno) {
		ImporteAlumnoDAO.updateImporteAlumno(importealumno);
	}

	@Override
	public void deleteImporteAlumno(int id_importealumno) {
		ImporteAlumnoDAO.deleteImporteAlumno(id_importealumno);
	}
    
    
}

