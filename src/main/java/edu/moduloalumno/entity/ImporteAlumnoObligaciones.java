package edu.moduloalumno.entity;

import java.io.Serializable;

public class ImporteAlumnoObligaciones implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
	private Integer id_importe_alumno_obligaciones;
	
    private Integer cod_alumno;
    
    private Integer cod_programa;
    
    private Integer cod_concepto;
    
    private double importe;
    
    private Integer id_tipo_obligacion;
    
    private String id_moneda;
    
    private Integer id_tobligacion_estado;
    
    private String descripcion;
    
    public ImporteAlumnoObligaciones() {
    }
    
    public ImporteAlumnoObligaciones(Integer id_importe_alumno_obligaciones,Integer cod_alumno, Integer cod_programa, Integer cod_concepto, double importe, Integer id_tipo_obligacion, String id_moneda, Integer id_tobligacion_estado, String descripcion) {
    	this.id_importe_alumno_obligaciones = id_importe_alumno_obligaciones;
    	this.cod_alumno = cod_alumno;
        this.cod_programa = cod_programa;
        this.cod_concepto = cod_concepto;
        this.importe = importe;
        this.id_tipo_obligacion = id_tipo_obligacion;
        this.id_moneda = id_moneda;
        this.id_tobligacion_estado = id_tobligacion_estado;
        this.descripcion = descripcion;
    }
    
    public Integer getId_importe_alumno_obligaciones() {
		return id_importe_alumno_obligaciones;
	}

	public void setId_importe_alumno_obligaciones(Integer id_importe_alumno_obligaciones) {
		this.id_importe_alumno_obligaciones = id_importe_alumno_obligaciones;
	}

	public Integer getCod_alumno() {
		return cod_alumno;
	}

	public void setCod_alumno(Integer cod_alumno) {
		this.cod_alumno = cod_alumno;
	}

	public Integer getCod_programa() {
		return cod_programa;
	}

	public void setCod_programa(Integer cod_programa) {
		this.cod_programa = cod_programa;
	}

	public Integer getCod_concepto() {
		return cod_concepto;
	}

	public void setCod_concepto(Integer cod_concepto) {
		this.cod_concepto = cod_concepto;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Integer getId_tipo_obligacion() {
		return id_tipo_obligacion;
	}

	public void setId_tipo_obligacion(Integer id_tipo_obligacion) {
		this.id_tipo_obligacion = id_tipo_obligacion;
	}

	public String getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(String id_moneda) {
		this.id_moneda = id_moneda;
	}

	public Integer getId_tobligacion_estado() {
		return id_tobligacion_estado;
	}

	public void setId_tobligacion_estado(Integer id_tobligacion_estado) {
		this.id_tobligacion_estado = id_tobligacion_estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ImporteAlumnoObligaciones [cod_alumno=" + cod_alumno + ", cod_programa=" + cod_programa
				+ ", cod_concepto=" + cod_concepto + ", importe=" + importe + ", id_tipo_obligacion="
				+ id_tipo_obligacion + ", id_moneda=" + id_moneda + ", id_tobligacion_estado=" + id_tobligacion_estado
				+ ", descripcion=" + descripcion + "]";
	}
    
}
