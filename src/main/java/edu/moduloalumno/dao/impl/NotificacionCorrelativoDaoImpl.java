package edu.moduloalumno.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.INotificacionCorrelativoDao;
import edu.moduloalumno.entity.NotificacionCorrelativo;
import edu.moduloalumno.rowmapper.NotificacionCorrelativoRowMapper;

@Transactional
@Repository
public class NotificacionCorrelativoDaoImpl implements INotificacionCorrelativoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	 
	@Override
	public List<NotificacionCorrelativo> getNotificacionCorrelativos() {
		String sql="SELECT anio,n_correlativo,l_ultimo FROM notificacion_correlativos";
		RowMapper<NotificacionCorrelativo> notifiCorre=new NotificacionCorrelativoRowMapper();
		List<NotificacionCorrelativo> lista=this.jdbcTemplate.query(sql, notifiCorre);
		
		
		return lista;
	}

	@Override
	public void actualizarNotifiCorrelativo(NotificacionCorrelativo notifiCorre) {
		String sql = "UPDATE notificacion_correlativos SET "
				+ " n_correlativo = ?"
				+ " WHERE anio = ? ;";
		System.out.println("query= "+sql);
		jdbcTemplate.update(sql,notifiCorre.getN_correlativo(),notifiCorre.getAnio());
		
	}

}
