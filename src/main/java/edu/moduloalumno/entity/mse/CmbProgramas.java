package edu.moduloalumno.entity.mse;

import java.io.Serializable;

import edu.moduloalumno.entity.Facultad;
import edu.moduloalumno.entity.Usuario;

public class CmbProgramas implements Serializable {

    private static final long serialVersionUID = 1L;

    private String value;

    private String label;

   

    public CmbProgramas() {
    }



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	@Override
	public String toString() {
		return "CmbProgramas [value=" + value + ", label=" + label + "]";
	}




   
    
}
