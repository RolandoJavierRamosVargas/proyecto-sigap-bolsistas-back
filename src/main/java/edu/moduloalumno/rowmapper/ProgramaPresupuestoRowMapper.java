package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.Presupuesto;
import edu.moduloalumno.entity.ProgramaPresupuesto;

public class ProgramaPresupuestoRowMapper implements RowMapper<ProgramaPresupuesto> {

	@Override
	public ProgramaPresupuesto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProgramaPresupuesto programaPresupuesto = new  ProgramaPresupuesto();
		programaPresupuesto.setCiclo(rs.getString("ciclo"));
		programaPresupuesto.setConcepto(rs.getString("concepto"));
		programaPresupuesto.setDescripcion_min(rs.getString("descripcion_min"));
		programaPresupuesto.setImporte(rs.getInt("importe"));
		programaPresupuesto.setMoneda(rs.getString("moneda"));
		return programaPresupuesto;
	}

}
