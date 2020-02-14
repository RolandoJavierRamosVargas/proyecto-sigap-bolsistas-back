package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.ImporteAlumno;

public class ImporteAlumnoRowMapper implements RowMapper<ImporteAlumno>{
    
        @Override
        public ImporteAlumno mapRow(ResultSet row, int rowNum) throws SQLException {
		ImporteAlumno importealumno = new ImporteAlumno();
                importealumno.setCod_alumno(row.getString("cod_alumno"));
                importealumno.setCod_programa(row.getInt("cod_programa"));
                importealumno.setCod_concepto(row.getInt("cod_concepto"));
                importealumno.setImporte(row.getDouble("importe"));
		return importealumno;
	}
   
}
