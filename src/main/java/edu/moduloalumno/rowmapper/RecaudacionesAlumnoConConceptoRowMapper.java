package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.RecaudacionesAlumnoConConcepto;


public class RecaudacionesAlumnoConConceptoRowMapper implements RowMapper<RecaudacionesAlumnoConConcepto> {

	@Override
	public RecaudacionesAlumnoConConcepto mapRow(ResultSet rs, int rsNum) throws SQLException {
		RecaudacionesAlumnoConConcepto recaudaciones = new RecaudacionesAlumnoConConcepto();
		recaudaciones.setRepitencia(rs.getString("repitencia"));
		recaudaciones.setIdRec(rs.getInt("id_rec"));
		recaudaciones.setIdAlum(rs.getInt("id_alum"));
		recaudaciones.setApeNom(rs.getString("ape_nom"));
		recaudaciones.setCiclo(rs.getInt("ciclo"));
		recaudaciones.setConcepto(rs.getString("concepto"));
		recaudaciones.setDni(rs.getString("dni"));
		recaudaciones.setNumero(rs.getString("numero"));
		recaudaciones.setNombre(rs.getString("nombre"));
		recaudaciones.setMoneda(rs.getString("id_moneda"));
		recaudaciones.setMoneda2(rs.getString("moneda"));
		recaudaciones.setImporte(rs.getDouble("importe"));
		recaudaciones.setIdconcepto(rs.getInt("id_concepto"));
		recaudaciones.setFecha(rs.getDate("fecha"));
		recaudaciones.setAnio_ingreso(rs.getString("anio_ingreso"));
		recaudaciones.setIdPrograma(rs.getInt("id_programa"));
		recaudaciones.setNomPrograma(rs.getString("nom_programa")); //
		recaudaciones.setSigla_programa(rs.getString("sigla_programa")); 
		recaudaciones.setCodAlumno(rs.getString("cod_alumno"));
		recaudaciones.setEstado(rs.getString("estado"));
		recaudaciones.setObservacion(rs.getString("observacion"));
		recaudaciones.setDescripcion_ubi(rs.getString("descripcion_ubi"));
		recaudaciones.setDescripcion_tipo(rs.getString("descripcion_tipo"));
		recaudaciones.setValidado(rs.getBoolean("validado"));
		recaudaciones.setEstado_civil(rs.getString("estado_civil"));
		recaudaciones.setId_tip_grado(rs.getString("id_tip_grado"));

		return recaudaciones;
	}

}
