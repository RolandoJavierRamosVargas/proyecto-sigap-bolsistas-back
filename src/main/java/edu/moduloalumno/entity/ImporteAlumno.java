package edu.moduloalumno.entity;

import java.io.Serializable;

public class ImporteAlumno implements Serializable {
    
    private static final long serialVersionUID = 1L;
        
    private String cod_alumno;
    
    private Integer cod_programa;
    
    private Integer cod_concepto;
    
    private Double importe;

    private Integer id_tipo_recaudacion;
    
    private String id_moneda;
    
    

    public String getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(String id_moneda) {
		this.id_moneda = id_moneda;
	}

	public ImporteAlumno() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ImporteAlumno(String cod_alumno, Integer cod_programa, Integer cod_concepto, Double importe,
			Integer id_tipo_recaudacion, String id_moneda) {
		super();
		this.cod_alumno = cod_alumno;
		this.cod_programa = cod_programa;
		this.cod_concepto = cod_concepto;
		this.importe = importe;
		this.id_tipo_recaudacion = id_tipo_recaudacion;
		this.id_moneda = id_moneda;
	}

	public Integer getId_tipo_recaudacion() {
		return id_tipo_recaudacion;
	}

	public void setId_tipo_recaudacion(Integer id_tipo_recaudacion) {
		this.id_tipo_recaudacion = id_tipo_recaudacion;
	}

	public String getCod_alumno() {
        return cod_alumno;
    }

    public void setCod_alumno(String cod_alumno) {
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

	@Override
	public String toString() {
		return "ImporteAlumno [cod_alumno=" + cod_alumno + ", cod_programa=" + cod_programa + ", cod_concepto="
				+ cod_concepto + ", importe=" + importe + ", id_tipo_recaudacion=" + id_tipo_recaudacion
				+ ", id_moneda=" + id_moneda + "]";
	}


   

}

