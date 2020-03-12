package edu.moduloalumno.entity;

import java.util.Date;

public class NotificacionDeudas {
	private Integer id_notificacion_deudas;
	private String cod_alumno;
	private Integer id_programa;
	private Integer n_notificacion;
	private Integer anio_notificacion;
	private Date fecha_notificacion;
	private String id_moneda;
	private Integer id_concepto;
	private Double importe_deuda;
	private String l_ultimo;
	public NotificacionDeudas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId_notificacion_deudas() {
		return id_notificacion_deudas;
	}
	public void setId_notificacion_deudas(Integer id_notificacion_deudas) {
		this.id_notificacion_deudas = id_notificacion_deudas;
	}
	public String getCod_alumno() {
		return cod_alumno;
	}
	public void setCod_alumno(String cod_alumno) {
		this.cod_alumno = cod_alumno;
	}
	public Integer getId_programa() {
		return id_programa;
	}
	public void setId_programa(Integer id_programa) {
		this.id_programa = id_programa;
	}
	public Integer getN_notificacion() {
		return n_notificacion;
	}
	public void setN_notificacion(Integer n_notificacion) {
		this.n_notificacion = n_notificacion;
	}
	public Integer getAnio_notificacion() {
		return anio_notificacion;
	}
	public void setAnio_notificacion(Integer anio_notificacion) {
		this.anio_notificacion = anio_notificacion;
	}
	public Date getFecha_notificacion() {
		return fecha_notificacion;
	}
	public void setFecha_notificacion(Date fecha_notificacion) {
		this.fecha_notificacion = fecha_notificacion;
	}
	public String getId_moneda() {
		return id_moneda;
	}
	public void setId_moneda(String id_moneda) {
		this.id_moneda = id_moneda;
	}
	public Integer getId_concepto() {
		return id_concepto;
	}
	public void setId_concepto(Integer id_concepto) {
		this.id_concepto = id_concepto;
	}
	public Double getImporte_deuda() {
		return importe_deuda;
	}
	public void setImporte_deuda(Double importe_deuda) {
		this.importe_deuda = importe_deuda;
	}
	public String getL_ultimo() {
		return l_ultimo;
	}
	public void setL_ultimo(String l_ultimo) {
		this.l_ultimo = l_ultimo;
	}
	@Override
	public String toString() {
		return "NotificacionDeudas [id_notificacion_deudas=" + id_notificacion_deudas + ", cod_alumno=" + cod_alumno
				+ ", id_programa=" + id_programa + ", n_notificacion=" + n_notificacion + ", anio_notificacion="
				+ anio_notificacion + ", fecha_notificacion=" + fecha_notificacion + ", id_moneda=" + id_moneda
				+ ", id_concepto=" + id_concepto + ", importe_deuda=" + importe_deuda + ", l_ultimo=" + l_ultimo + "]";
	}
	
	
	
	
	
}
