package edu.moduloalumno.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.INotificacionDeudasDao;
import edu.moduloalumno.entity.NotificacionDeudas;

@Transactional
@Repository
public class NotificacionDeudasDaoImpl implements INotificacionDeudasDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertNotificacionDeudas(NotificacionDeudas notifiDeudas) {
		
		String sql = "INSERT INTO notificacion_deudas (cod_alumno,id_programa,n_notificacion,anio_notificacion,fecha_notificacion,id_moneda,"
				+ "id_concepto,importe_deuda,l_ultimo) values (?, ?, ?,?, ?, ?,?, ?, ?)";
		jdbcTemplate.update(sql,
								notifiDeudas.getCod_alumno(),notifiDeudas.getId_programa(),notifiDeudas.getN_notificacion(),
								notifiDeudas.getAnio_notificacion(),notifiDeudas.getFecha_notificacion(),notifiDeudas.getId_moneda(),
								notifiDeudas.getId_concepto(),notifiDeudas.getImporte_deuda(),notifiDeudas.getL_ultimo());
		
		
	}

	@Override
	public void updateNotificacionDeudas(String codigo_alumno) {
		String sql="UPDATE notificacion_deudas SET "
				+" l_ultimo='N' "
				+" WHERE cod_alumno = ? ;";
		jdbcTemplate.update(sql,codigo_alumno);
	}

}
