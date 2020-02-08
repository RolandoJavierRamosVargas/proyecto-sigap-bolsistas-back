package edu.moduloalumno.dao.mse;


import java.util.List;

import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.entity.mse.AlumnoMse;
import edu.moduloalumno.entity.mse.CmbProgramas;
import edu.moduloalumno.entity.mse.ConProgramaPorAlumno;

public interface IAlumnoMseDAO {

	AlumnoMse getAlumnoByCod(String codAlumno);

	void updateAlumno(AlumnoMse alumno);
	
	List<ConProgramaPorAlumno> consultaProgramaPorAlumno(String codAlumno);
	
	List<CmbProgramas> consultaListaProgramas(String codigo);
	
}