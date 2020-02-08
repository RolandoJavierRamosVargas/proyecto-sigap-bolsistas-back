package edu.moduloalumno.service.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.mse.IAlumnoMseDAO;
import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.entity.mse.AlumnoMse;
import edu.moduloalumno.entity.mse.CmbProgramas;
import edu.moduloalumno.entity.mse.ConProgramaPorAlumno;
import edu.moduloalumno.service.mse.IAlumnoService;

@Service
public class AlumnoServiceImpl2 implements IAlumnoService {
	@Autowired
	private IAlumnoMseDAO alumnoDAO;

	@Override
	public void updateAlumno(AlumnoMse alumno) {
		alumnoDAO.updateAlumno(alumno);
		//llenar tabla persona
	}

	@Override
	public AlumnoMse getAlumnoByCod(String codAlumno) {
		AlumnoMse alumno = alumnoDAO.getAlumnoByCod(codAlumno);
		return alumno;
	}
	
	@Override
	public List<ConProgramaPorAlumno> conProgramaPorCodigo(String codAlumno) {
	
		return alumnoDAO.consultaProgramaPorAlumno(codAlumno);
	}

	@Override
	public List<CmbProgramas> consultaProgramas(String codigo) {

		return alumnoDAO.consultaListaProgramas(codigo);
	}

}