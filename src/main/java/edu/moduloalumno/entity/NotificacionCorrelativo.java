package edu.moduloalumno.entity;

public class NotificacionCorrelativo {
	private String anio;
	private Integer n_correlativo;
	private String l_ultimo;
	
	
	
	public NotificacionCorrelativo(String anio, Integer n_correlativo, String l_ultimo) {
		super();
		this.anio = anio;
		this.n_correlativo = n_correlativo;
		this.l_ultimo = l_ultimo;
	}
	public NotificacionCorrelativo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public Integer getN_correlativo() {
		return n_correlativo;
	}
	public void setN_correlativo(Integer n_correlativo) {
		this.n_correlativo = n_correlativo;
	}
	public String getL_ultimo() {
		return l_ultimo;
	}
	public void setL_ultimo(String l_ultimo) {
		this.l_ultimo = l_ultimo;
	}
	@Override
	public String toString() {
		return "NotificacionCorrelativo [anio=" + anio + ", n_correlativo=" + n_correlativo + ", l_ultimo=" + l_ultimo
				+ "]";
	}
	
	
	
}
