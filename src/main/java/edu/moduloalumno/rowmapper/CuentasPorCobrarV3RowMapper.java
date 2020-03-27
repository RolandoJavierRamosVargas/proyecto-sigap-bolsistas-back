package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.CuentasPorCobrar2;
import edu.moduloalumno.entity.DeudoresPosgradoMasInfo;

public class CuentasPorCobrarV3RowMapper implements RowMapper<DeudoresPosgradoMasInfo> {
	@Override
	public DeudoresPosgradoMasInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DeudoresPosgradoMasInfo deudoresPosgrado= new DeudoresPosgradoMasInfo();
		
		deudoresPosgrado.setCod_alumno(rs.getString("cod_alumno"));
		deudoresPosgrado.setId_programa(rs.getInt("id_programa"));
		
		
		
		deudoresPosgrado.setApe_paterno(rs.getString("ape_paterno"));
		deudoresPosgrado.setApe_materno(rs.getString("ape_materno"));
		deudoresPosgrado.setNom_alumno(rs.getString("nom_alumno"));
		deudoresPosgrado.setN_prioridad(rs.getInt("n_prioridad"));
		deudoresPosgrado.setSigla_programa(rs.getString("sigla_programa"));
		deudoresPosgrado.setAnio_ingreso(rs.getString("anio_ingreso"));
		deudoresPosgrado.setCod_perm(rs.getString("cod_perm"));
		deudoresPosgrado.setMax_anio_estudio(rs.getInt("max_anio_estudio"));
		deudoresPosgrado.setBeneficio_otorgado(rs.getInt("beneficio_otorgado"));
		deudoresPosgrado.setAutorizacion(rs.getString("autorizacion"));
		deudoresPosgrado.setMoneda(rs.getString("moneda"));
		deudoresPosgrado.setId_moneda(rs.getString("id_moneda"));
		deudoresPosgrado.setN_prioridad2(rs.getInt("prioridad"));
		
		deudoresPosgrado.setId_concepto(rs.getInt("id_concepto"));
		
		deudoresPosgrado.setConcepto(rs.getString("concepto"));
		deudoresPosgrado.setDescripcion_min(rs.getString("descripcion_min"));
		deudoresPosgrado.setImporte_xpagar(rs.getDouble("importe_xpagar"));
		deudoresPosgrado.setImporte_pagado(rs.getDouble("importe_pagado"));
		deudoresPosgrado.setDeuda(rs.getDouble("deuda"));
		
		deudoresPosgrado.setNotificacion_deuda(rs.getString("notificacion_deuda"));
		deudoresPosgrado.setDeuda_estado(rs.getString("deuda_estado"));
		
		
		deudoresPosgrado.setEstado(rs.getString("estado"));
		deudoresPosgrado.setCoe_alumno(rs.getString("coe_alumno"));
		deudoresPosgrado.setCoe_alu_personal(rs.getString("coe_alu_personal"));
		deudoresPosgrado.setTel_alu_movil(rs.getString("tel_alu_movil"));
		deudoresPosgrado.setTel_alumno(rs.getString("tel_alumno"));
		deudoresPosgrado.setDes_doc_identidad(rs.getString("des_doc_identidad"));
		deudoresPosgrado.setDid_alumno(rs.getString("did_alumno"));
		deudoresPosgrado.setDir_tip_via(rs.getString("dir_tip_via"));
		deudoresPosgrado.setDir_tip_via_nom(rs.getString("dir_tip_via_nom"));
		deudoresPosgrado.setDir_num_puerta(rs.getInt("dir_num_puerta"));
		deudoresPosgrado.setDir_num_piso(rs.getString("dir_num_piso"));
		deudoresPosgrado.setDir_num_dpto(rs.getString("dir_num_dpto"));
		deudoresPosgrado.setDir_num_mz(rs.getString("dir_num_mz"));
		deudoresPosgrado.setDir_num_lote(rs.getString("dir_num_lote"));
		deudoresPosgrado.setDir_num_km(rs.getString("dir_num_km"));
		deudoresPosgrado.setDir_tip_loc(rs.getString("dir_tip_loc"));
		deudoresPosgrado.setDir_tip_loc_nom(rs.getString("dir_tip_loc_nom"));
		deudoresPosgrado.setDepartamento(rs.getString("departamento"));
		deudoresPosgrado.setProvincia(rs.getString("provincia"));
		deudoresPosgrado.setDistrito(rs.getString("distrito"));
		
		
		
		
		
		return deudoresPosgrado;
	}
}
