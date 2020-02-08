package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.ImporteAlumnoObligaciones;

public class ImporteAlumnoObligacionesRowMapper implements RowMapper<ImporteAlumnoObligaciones>{
	
		@Override
	    public ImporteAlumnoObligaciones mapRow(ResultSet row, int rowNum) throws SQLException {
		ImporteAlumnoObligaciones importealumnoobligaciones = new ImporteAlumnoObligaciones();
				importealumnoobligaciones.setId_importe_alumno_obligaciones(row.getInt("id_importe_alumno_obligaciones"));
				importealumnoobligaciones.setCod_alumno(row.getInt("cod_alumno"));
	            importealumnoobligaciones.setCod_programa(row.getInt("cod_programa"));
	            importealumnoobligaciones.setCod_concepto(row.getInt("cod_concepto"));
	            importealumnoobligaciones.setImporte(row.getDouble("importe"));
	            importealumnoobligaciones.setId_tipo_obligacion(row.getInt("id_tipo_obligacion"));
	            importealumnoobligaciones.setId_moneda(row.getString("id_moneda"));
	            importealumnoobligaciones.setId_tobligacion_estado(row.getInt("id_tobligacion_estado"));
	            importealumnoobligaciones.setDescripcion(row.getString("descripcion"));
		return importealumnoobligaciones;
	}

}
