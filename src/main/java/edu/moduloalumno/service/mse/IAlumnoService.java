package edu.moduloalumno.service.mse;


import java.util.List;

import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.entity.mse.AlumnoMse;
import edu.moduloalumno.entity.mse.CmbProgramas;
import edu.moduloalumno.entity.mse.ConProgramaPorAlumno;

public interface IAlumnoService {
	
	AlumnoMse getAlumnoByCod(String codAlumno);

	void updateAlumno(AlumnoMse alumno);
	
	List<ConProgramaPorAlumno> conProgramaPorCodigo(String codAlumno);
	
	List<CmbProgramas> consultaProgramas(String codigo);
}