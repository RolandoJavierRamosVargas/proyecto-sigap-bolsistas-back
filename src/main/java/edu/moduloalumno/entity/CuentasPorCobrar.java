package edu.moduloalumno.entity;

public class CuentasPorCobrar {

	String cod_alumno;
	String ape_paterno;
	String ape_materno;
	String nom_alumno;
	String sigla_programa;
	String cod_perm;
	Integer max_anio_estudio;
	Integer beneficio_otorgado;
	String autorizacion;
	String caso;
	Integer n_prioridad;
	String concepto;
	String descripcion_min;
	Integer importe_pagado;
	Integer importe_xpagar;
	Integer deuda;
	
	
	
	public CuentasPorCobrar() {
		
	}
	@Override
	public String toString() {
		return "CuentasPorCobrar [cod_alumno=" + cod_alumno + ", ape_paterno=" + ape_paterno + ", ape_materno="
				+ ape_materno + ", nom_alumno=" + nom_alumno + ", sigla_programa=" + sigla_programa + ", cod_perm="
				+ cod_perm + ", max_anio_estudio=" + max_anio_estudio + ", beneficio_otorgado=" + beneficio_otorgado
				+ ", autorizacion=" + autorizacion + ", caso=" + caso + ", n_prioridad=" + n_prioridad + ", concepto="
				+ concepto + ", descripcion_min=" + descripcion_min + ", importe_pagado=" + importe_pagado
				+ ", importe_xpagar=" + importe_xpagar + ", deuda=" + deuda + "]";
	}
	public String getCod_alumno() {
		return cod_alumno;
	}
	public void setCod_alumno(String cod_alumno) {
		this.cod_alumno = cod_alumno;
	}
	public String getApe_paterno() {
		return ape_paterno;
	}
	public void setApe_paterno(String ape_paterno) {
		this.ape_paterno = ape_paterno;
	}
	public String getApe_materno() {
		return ape_materno;
	}
	public void setApe_materno(String ape_materno) {
		this.ape_materno = ape_materno;
	}
	public String getNom_alumno() {
		return nom_alumno;
	}
	public void setNom_alumno(String nom_alumno) {
		this.nom_alumno = nom_alumno;
	}
	public String getSigla_programa() {
		return sigla_programa;
	}
	public void setSigla_programa(String sigla_programa) {
		this.sigla_programa = sigla_programa;
	}
	public String getCod_perm() {
		return cod_perm;
	}
	public void setCod_perm(String cod_perm) {
		this.cod_perm = cod_perm;
	}
	public Integer getMax_anio_estudio() {
		return max_anio_estudio;
	}
	public void setMax_anio_estudio(Integer max_anio_estudio) {
		this.max_anio_estudio = max_anio_estudio;
	}
	public Integer getBeneficio_otorgado() {
		return beneficio_otorgado;
	}
	public void setBeneficio_otorgado(Integer beneficio_otorgado) {
		this.beneficio_otorgado = beneficio_otorgado;
	}
	public String getAutorizacion() {
		return autorizacion;
	}
	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}
	public String getCaso() {
		return caso;
	}
	public void setCaso(String caso) {
		this.caso = caso;
	}
	public Integer getN_prioridad() {
		return n_prioridad;
	}
	public void setN_prioridad(Integer n_prioridad) {
		this.n_prioridad = n_prioridad;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getDescripcion_min() {
		return descripcion_min;
	}
	public void setDescripcion_min(String descripcion_min) {
		this.descripcion_min = descripcion_min;
	}
	public Integer getImporte_pagado() {
		return importe_pagado;
	}
	public void setImporte_pagado(Integer importe_pagado) {
		this.importe_pagado = importe_pagado;
	}
	public Integer getImporte_xpagar() {
		return importe_xpagar;
	}
	public void setImporte_xpagar(Integer importe_xpagar) {
		this.importe_xpagar = importe_xpagar;
	}
	public Integer getDeuda() {
		return deuda;
	}
	public void setDeuda(Integer deuda) {
		this.deuda = deuda;
	}
	
	
	
	
}
