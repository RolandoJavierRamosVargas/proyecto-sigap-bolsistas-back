package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.CuentasPorCobrar;

public class CuentasPorCobrarRowMapper implements RowMapper<CuentasPorCobrar>{

	@Override
	public CuentasPorCobrar mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		CuentasPorCobrar cuentasXcobrar= new CuentasPorCobrar();
		cuentasXcobrar.setCod_alumno(rs.getString("cod_alumno"));
		cuentasXcobrar.setApe_paterno(rs.getString("ape_paterno"));
		cuentasXcobrar.setApe_materno(rs.getString("ape_materno"));
		cuentasXcobrar.setNom_alumno(rs.getString("nom_alumno"));
		cuentasXcobrar.setSigla_programa(rs.getString("sigla_programa"));
		cuentasXcobrar.setCod_perm(rs.getString("cod_perm"));
		cuentasXcobrar.setMax_anio_estudio(rs.getInt("max_anio_estudio"));
		cuentasXcobrar.setBeneficio_otorgado(rs.getInt("beneficio_otorgado"));
		cuentasXcobrar.setAutorizacion(rs.getString("autorizacion"));
		cuentasXcobrar.setMoneda(rs.getString("moneda"));
		cuentasXcobrar.setN_prioridad(rs.getInt("n_prioridad"));
		cuentasXcobrar.setConcepto(rs.getString("concepto"));
		cuentasXcobrar.setDescripcion_min(rs.getString("descripcion_min"));
		cuentasXcobrar.setImporte_xpagar(rs.getDouble("importe_xpagar"));
		cuentasXcobrar.setImporte_pagado(rs.getDouble("importe_pagado"));
		cuentasXcobrar.setDeuda(rs.getDouble("deuda"));
		cuentasXcobrar.setEstado(rs.getString("estado"));
		return cuentasXcobrar;
	}

}
