
package edu.moduloalumno.entity;

public class ProgramaPresupuesto {
	
	private String ciclo;
	private String concepto;
	private String descripcion_min;
	private String moneda;
	private Integer importe;
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
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
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Integer getImporte() {
		return importe;
	}
	public void setImporte(Integer importe) {
		this.importe = importe;
	}
	@Override
	public String toString() {
		return "ProgramaPresupuesto [ciclo=" + ciclo + ", concepto=" + concepto + ", descripcion_min=" + descripcion_min
				+ ", moneda=" + moneda + ", importe=" + importe + "]";
	}
	
	
	
	

}
