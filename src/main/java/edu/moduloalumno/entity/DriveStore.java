package edu.moduloalumno.entity;

import java.io.Serializable;

public class DriveStore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String rutaDrive;

	public String getRutaDrive() {
		return rutaDrive;
	}

	public void setRutaDrive(String rutaDrive) {
		this.rutaDrive = rutaDrive;
	}

	@Override
	public String toString() {
		return "DriveStore [rutaDrive=" + rutaDrive + "]";
	}
	
	
}
