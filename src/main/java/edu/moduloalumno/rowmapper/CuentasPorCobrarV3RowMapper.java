package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.CuentasPorCobrar2;

public class CuentasPorCobrarV3RowMapper implements RowMapper<CuentasPorCobrar2> {
	@Override
	public CuentasPorCobrar2 mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		CuentasPorCobrar2 cuentasXcobrar2= new CuentasPorCobrar2();
		
		cuentasXcobrar2.setId_programa(rs.getInt("id_programa"));
		cuentasXcobrar2.setId_concepto(rs.getInt("id_concepto"));
		cuentasXcobrar2.setId_moneda(rs.getString("id_moneda"));
		
		
		cuentasXcobrar2.setCod_alumno(rs.getString("cod_alumno"));
		cuentasXcobrar2.setApe_paterno(rs.getString("ape_paterno"));
		cuentasXcobrar2.setApe_materno(rs.getString("ape_materno"));
		cuentasXcobrar2.setNom_alumno(rs.getString("nom_alumno"));
		cuentasXcobrar2.setN_prioridad(rs.getInt("n_prioridad"));
		cuentasXcobrar2.setSigla_programa(rs.getString("sigla_programa"));
		cuentasXcobrar2.setAnio_ingreso(rs.getString("anio_ingreso"));
		cuentasXcobrar2.setCod_perm(rs.getString("cod_perm"));
		cuentasXcobrar2.setMax_anio_estudio(rs.getInt("max_anio_estudio"));
		cuentasXcobrar2.setBeneficio_otorgado(rs.getInt("beneficio_otorgado"));
		cuentasXcobrar2.setAutorizacion(rs.getString("autorizacion"));
		cuentasXcobrar2.setMoneda(rs.getString("moneda"));
		cuentasXcobrar2.setN_prioridad2(rs.getInt("prioridad"));
		cuentasXcobrar2.setConcepto(rs.getString("concepto"));
		cuentasXcobrar2.setDescripcion_min(rs.getString("descripcion_min"));
		cuentasXcobrar2.setImporte_xpagar(rs.getDouble("importe_xpagar"));
		cuentasXcobrar2.setImporte_pagado(rs.getDouble("importe_pagado"));
		cuentasXcobrar2.setDeuda(rs.getDouble("deuda"));
		cuentasXcobrar2.setEstado(rs.getString("estado"));
		cuentasXcobrar2.setCoe_alumno(rs.getString("coe_alumno"));
		cuentasXcobrar2.setCoe_alu_personal(rs.getString("coe_alu_personal"));
		cuentasXcobrar2.setTel_alu_movil(rs.getString("tel_alu_movil"));
		cuentasXcobrar2.setTel_alumno(rs.getString("tel_alumno"));
		cuentasXcobrar2.setDes_doc_identidad(rs.getString("des_doc_identidad"));
		cuentasXcobrar2.setDid_alumno(rs.getString("did_alumno"));
		cuentasXcobrar2.setDir_tip_via(rs.getString("dir_tip_via"));
		cuentasXcobrar2.setDir_tip_via_nom(rs.getString("dir_tip_via_nom"));
		cuentasXcobrar2.setDir_num_puerta(rs.getInt("dir_num_puerta"));
		cuentasXcobrar2.setDir_num_piso(rs.getString("dir_num_piso"));
		cuentasXcobrar2.setDir_num_dpto(rs.getString("dir_num_dpto"));
		cuentasXcobrar2.setDir_num_mz(rs.getString("dir_num_mz"));
		cuentasXcobrar2.setDir_num_lote(rs.getString("dir_num_lote"));
		cuentasXcobrar2.setDir_num_km(rs.getString("dir_num_km"));
		cuentasXcobrar2.setDir_tip_loc(rs.getString("dir_tip_loc"));
		cuentasXcobrar2.setDir_tip_loc_nom(rs.getString("dir_tip_loc_nom"));
		cuentasXcobrar2.setDepartamento(rs.getString("departamento"));
		cuentasXcobrar2.setProvincia(rs.getString("provincia"));
		cuentasXcobrar2.setDistrito(rs.getString("distrito"));
		
		
		return cuentasXcobrar2;
	}
}
