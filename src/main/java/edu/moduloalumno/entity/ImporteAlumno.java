package edu.moduloalumno.entity;

import java.io.Serializable;

public class ImporteAlumno implements Serializable {
    
    private static final long serialVersionUID = 1L;
        
    private Integer cod_alumno;
    
    private Integer cod_programa;
    
    private Integer cod_concepto;
    
    private double importe;

    public ImporteAlumno() {
    }

    public ImporteAlumno(Integer cod_alumno, Integer cod_programa, Integer cod_concepto, double importe) {
        this.cod_alumno = cod_alumno;
        this.cod_programa = cod_programa;
        this.cod_concepto = cod_concepto;
        this.importe = importe;
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


    @Override
    public String toString() {
        return "ImporteAlumno{" + ", cod_alumno=" + cod_alumno + ", cod_programa=" + cod_programa + ", cod_concepto=" + cod_concepto + ", importe=" + importe + '}';
    }

}

