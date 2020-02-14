package edu.moduloalumno.service;

import java.util.List;

import edu.moduloalumno.entity.ImporteAlumnoObligaciones;

public interface IImporteAlumnoObligacionesService {
	
		List<ImporteAlumnoObligaciones> getAllImporteAlumnosObligaciones();
		
		List<ImporteAlumnoObligaciones> getImporteAlumnoObligacionesImporte(String cod_alumno, int cod_programa);
	    
	    void addImporteAlumnoObligaciones(ImporteAlumnoObligaciones importealumnoobligaciones);
	    
	    void updateImporteAlumnoObligaciones(ImporteAlumnoObligaciones importealumnoobligaciones);
	    
	    void deleteImporteAlumnoObligaciones(int cod_alumno);

}
