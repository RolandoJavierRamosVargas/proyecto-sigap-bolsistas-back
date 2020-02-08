package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.AlumnoMse;

public class AlumnoMseRowMapper implements RowMapper<AlumnoMse> {
	@Override
	public AlumnoMse mapRow(ResultSet row, int rowNum) throws SQLException {
		AlumnoMse alumno = new AlumnoMse();
		alumno.setCodigoAlumno(row.getString("cod_alumno"));		
		alumno.setDni(row.getString("dni_m"));
		alumno.setApellidoPaterno(row.getString("ape_paterno"));
		alumno.setApellidoMaterno(row.getString("ape_materno"));
		alumno.setNombre(row.getString("nom_alumno"));
		alumno.setFechaNacimiento(row.getDate("nac_fecha"));
		//alumno.setDomicilioActual(row.getString(".....");
		//alumno.setDistrito(row.getString("......"));
		alumno.setTelefonoFijo(row.getString("telefono"));
		alumno.setTelefonoCelular(row.getString("telefono_movil"));
		alumno.setCorreoPersonal(row.getString("correo_personal"));
		alumno.setCorreoLaboral(row.getString("correo"));
		
		return alumno;
	}
}