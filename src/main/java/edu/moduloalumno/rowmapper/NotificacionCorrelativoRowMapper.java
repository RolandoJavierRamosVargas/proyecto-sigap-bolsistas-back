package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.NotificacionCorrelativo;

public class NotificacionCorrelativoRowMapper implements RowMapper<NotificacionCorrelativo> {

	@Override
	public NotificacionCorrelativo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		NotificacionCorrelativo notifiCorre=new NotificacionCorrelativo();
		notifiCorre.setAnio(rs.getString("anio"));
		notifiCorre.setN_correlativo(rs.getInt("n_correlativo"));
		notifiCorre.setL_ultimo(rs.getString("l_ultimo"));
		
		return notifiCorre;
	}

}
