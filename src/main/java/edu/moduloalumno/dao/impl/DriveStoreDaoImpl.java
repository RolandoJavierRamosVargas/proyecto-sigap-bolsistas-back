package edu.moduloalumno.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.moduloalumno.dao.IDriveStoreDao;
import edu.moduloalumno.entity.Configuracion2;
import edu.moduloalumno.entity.DriveStore;
import edu.moduloalumno.entity.Recaudaciones;
import edu.moduloalumno.rowmapper.ConfiguracionRowMapper;

@Repository
public class DriveStoreDaoImpl implements IDriveStoreDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public DriveStore driveStoreName(String codigo) {
		String sql = "select concat(b.n_drive_google,'.',trim(b.sigla_programa),',',a.anio_ingreso,',', " + 
				"trim(a.cod_alumno),'-',trim(a.ape_paterno),'.',trim(a.ape_materno),'.',trim(a.nom_alumno)) as rutaDrive " + 
				"from alumno_programa a , programa b " + 
				"where a.id_programa=b.id_programa " + 
				"and a.cod_alumno= ? ;" + 
				"";

		RowMapper<DriveStore> rowMapper = new BeanPropertyRowMapper<DriveStore>(DriveStore.class);
		DriveStore listDrive =  this.jdbcTemplate.queryForObject(sql, rowMapper,codigo);
		return listDrive;
	}

}
