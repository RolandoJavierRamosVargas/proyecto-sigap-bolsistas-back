package edu.moduloalumno.dao;

import java.util.List;

import edu.moduloalumno.entity.ImporteAlumno;

public interface IImporteAlumnoDAO {
    
        List<ImporteAlumno> getAllImporteAlumnos();
        
        ImporteAlumno getImporteAlumnoByAlumnoId(int cod_alumno);
        
        ImporteAlumno getImporteAlumnoImporte(int cod_alumno,int cod_programa, int cod_concepto);
        
        double getImporteAlumno(ImporteAlumno importealumno);
        
        void addImporteAlumno(ImporteAlumno importealumno);
        
        void updateImporteAlumno(ImporteAlumno importealumno);
        
        void deleteImporteAlumno(int cod_alumno);
        
}

