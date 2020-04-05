package edu.moduloalumno.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.ITiposRecaudacionDAO;
import edu.moduloalumno.entity.TiposRecaudacion;
import edu.moduloalumno.rowmapper.TiposRecaudacionRowMapper;

@Transactional
@Repository
public class TipoRecaudacionDAOImpl implements ITiposRecaudacionDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<TiposRecaudacion> listar() {
		String sql="SELECT id_tipo_recaudacion, desc_tipo_recaudacion FROM TIPO_RECAUDACION;";
		RowMapper<TiposRecaudacion> rowMapper = new TiposRecaudacionRowMapper();
		List<TiposRecaudacion> tiposRecaudacion =  jdbcTemplate.query(sql, rowMapper);
		return tiposRecaudacion;
	}

}
