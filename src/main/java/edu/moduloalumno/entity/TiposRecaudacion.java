package edu.moduloalumno.entity;

import java.io.Serializable;

public class TiposRecaudacion implements Serializable {

	private Integer id_tipo_recaudacion;
	private String desc_tipo_recaudacion;

	public TiposRecaudacion() {

	}

	public TiposRecaudacion(Integer id_tipo_recaudacion, String desc_tipo_recaudacion) {
		super();
		this.id_tipo_recaudacion = id_tipo_recaudacion;
		this.desc_tipo_recaudacion = desc_tipo_recaudacion;
	}

	public Integer getId_tipo_recaudacion() {
		return id_tipo_recaudacion;
	}

	public void setId_tipo_recaudacion(Integer id_tipo_recaudacion) {
		this.id_tipo_recaudacion = id_tipo_recaudacion;
	}

	@Override
	public String toString() {
		return "TiposDecaudacion [id_tipo_recaudacion=" + id_tipo_recaudacion + ", desc_tipo_recaudacion="
				+ desc_tipo_recaudacion + "]";
	}

	public String getDesc_tipo_recaudacion() {
		return desc_tipo_recaudacion;
	}

	public void setDesc_tipo_recaudacion(String desc_tipo_recaudacion) {
		this.desc_tipo_recaudacion = desc_tipo_recaudacion;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5884039246880863807L;

}
