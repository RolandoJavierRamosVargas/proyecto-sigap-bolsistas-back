package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.AlumnoMse;
import edu.moduloalumno.entity.mse.CmbProgramas;
import edu.moduloalumno.entity.mse.ConProgramaPorAlumno;

public class CmbProgramasRowMapper implements RowMapper<CmbProgramas> {
	@Override
	public CmbProgramas mapRow(ResultSet row, int rowNum) throws SQLException {
		CmbProgramas alumno = new CmbProgramas();
		alumno.setValue(row.getString("id_programa"));		
		alumno.setLabel(row.getString("nom_programa"));
	
		return alumno;
	}
}