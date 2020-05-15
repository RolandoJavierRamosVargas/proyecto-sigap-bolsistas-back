package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.RecaudacionesJOINAlumnoJOINConceptoJOINFacultad;
import edu.moduloalumno.entity.RecaudacionesJoinAlumnoJoinConceptoJoinFacultadWithDescription;

public class RecaudacionesJoinAlumnoJoinConceptoJoinFacultadWithDescriptionRowMapper implements RowMapper<RecaudacionesJOINAlumnoJOINConceptoJOINFacultad> {

	@Override
	public RecaudacionesJOINAlumnoJOINConceptoJOINFacultad mapRow(ResultSet row, int rowNum)
			throws SQLException {
		RecaudacionesJOINAlumnoJOINConceptoJOINFacultad recaudacion = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultad();
		
		recaudacion.setR_id_tipo_recaudacion(row.getInt("r_id_tipo_recaudacion"));
		recaudacion.setC_id_tipo_recaudacion(row.getInt("c_id_tipo_recaudacion"));
		recaudacion.setDescripcion_recaudacion(row.getString("descripcion_recaudacion"));
		recaudacion.setRepitencia(row.getString("repitencia"));
		recaudacion.setIdRec(row.getInt("id_rec"));
		recaudacion.setIdAlum(row.getInt("id_alum"));
		recaudacion.setEstado(row.getString("estado"));
		recaudacion.setApeNom(row.getString("ape_nom"));
		recaudacion.setCiclo(row.getInt("ciclo"));
		recaudacion.setConcepto(row.getString("concepto"));
		recaudacion.setIdconcepto(row.getInt("id_concepto"));
		recaudacion.setDni(row.getString("dni"));
		recaudacion.setNumero(row.getString("numero"));
		recaudacion.setNombre(row.getString("nombre"));
		recaudacion.setMoneda(row.getString("id_moneda"));
		recaudacion.setMoneda2(row.getString("moneda"));
		recaudacion.setImporte(row.getDouble("importe"));
		recaudacion.setId_tipo_recaudacion(row.getInt("id_tipo_recaudacion"));
		recaudacion.setFecha(row.getDate("fecha"));
		recaudacion.setAnio_ingreso(row.getString("anio_ingreso"));
		recaudacion.setNomPrograma(row.getString("nom_programa")); //
		recaudacion.setIdPrograma(row.getInt("id_programa"));
		recaudacion.setSigla_programa(row.getString("sigla_programa")); 
		
		recaudacion.setCodAlumno(row.getString("cod_alumno"));
		recaudacion.setEstado_civil(row.getString("estado_civil"));
		recaudacion.setObservacion(row.getString("observacion"));
		recaudacion.setObservacion_upg(row.getString("observacion_upg"));
		
		recaudacion.setDescripcion_ubi(row.getString("descripcion_ubi"));
		recaudacion.setDescripcion_tipo(row.getString("descripcion_tipo"));
		recaudacion.setValidado(row.getBoolean("validado"));
		return recaudacion;
	}

}
