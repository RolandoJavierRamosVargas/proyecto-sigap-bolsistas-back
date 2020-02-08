package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.AlumnoMse;
import edu.moduloalumno.entity.mse.ConProgramaPorAlumno;

public class ConProgramaPorAlumnoRowMapper implements RowMapper<ConProgramaPorAlumno> {
	@Override
	public ConProgramaPorAlumno mapRow(ResultSet row, int rowNum) throws SQLException {
		ConProgramaPorAlumno alumno = new ConProgramaPorAlumno();
		alumno.setCodAlumno(row.getString("cod_alumno"));		
		alumno.setAnioIngreso(row.getString("anio_ingreso"));
//		alumno.setAnioEgreso(row.getString("anio_egreso"));
		alumno.setNomPrograma(row.getString("nom_programa"));
		alumno.setSiglaPrograma(row.getString("sigla_programa"));
	
		return alumno;
	}
}