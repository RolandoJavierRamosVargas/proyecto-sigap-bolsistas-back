package edu.moduloalumno.entity;

import java.io.Serializable;

public class RecaudacionesJoinAlumnoJoinConceptoJoinFacultadWithDescription implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer r_id_tipo_recaudacion;
	private Integer c_id_tipo_recaudacion;
	private String descripcion_recaudacion;
	
	private RecaudacionesJOINAlumnoJOINConceptoJOINFacultad recaudaciones;
	
	

	public RecaudacionesJoinAlumnoJoinConceptoJoinFacultadWithDescription() {
		this.recaudaciones  = new RecaudacionesJOINAlumnoJOINConceptoJOINFacultad();
	}

	public Integer getR_id_tipo_recaudacion() {
		return r_id_tipo_recaudacion;
	}

	public void setR_id_tipo_recaudacion(Integer r_id_tipo_recaudacion) {
		this.r_id_tipo_recaudacion = r_id_tipo_recaudacion;
	}

	public Integer getC_id_tipo_recaudacion() {
		return c_id_tipo_recaudacion;
	}

	public void setC_id_tipo_recaudacion(Integer c_id_tipo_recaudacion) {
		this.c_id_tipo_recaudacion = c_id_tipo_recaudacion;
	}

	public String getDescripcion_recaudacion() {
		return descripcion_recaudacion;
	}

	public void setDescripcion_recaudacion(String descripcion_recaudacion) {
		this.descripcion_recaudacion = descripcion_recaudacion;
	}

	public RecaudacionesJOINAlumnoJOINConceptoJOINFacultad getRecaudaciones() {
		return recaudaciones;
	}

	public void setRecaudaciones(RecaudacionesJOINAlumnoJOINConceptoJOINFacultad recaudaciones) {
		this.recaudaciones = recaudaciones;
	}

	@Override
	public String toString() {
		return "RecaudacionesJoinAlumnoJoinConceptoJoinFacultadWithDescription [r_id_tipo_recaudacion="
				+ r_id_tipo_recaudacion + ", c_id_tipo_recaudacion=" + c_id_tipo_recaudacion
				+ ", descripcion_recaudacion=" + descripcion_recaudacion + ", recaudaciones=" + recaudaciones + "]";
	}
	
	
}
