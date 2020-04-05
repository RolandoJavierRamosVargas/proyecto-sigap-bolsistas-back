package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.TiposRecaudacion;

public class TiposRecaudacionRowMapper implements  RowMapper<TiposRecaudacion>{

	@Override
	public TiposRecaudacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		 TiposRecaudacion tipos= new TiposRecaudacion();
		 tipos.setId_tipo_recaudacion(rs.getInt("id_tipo_recaudacion"));
		 tipos.setDesc_tipo_recaudacion(rs.getString("desc_tipo_recaudacion"));
		return tipos;
	}

}
