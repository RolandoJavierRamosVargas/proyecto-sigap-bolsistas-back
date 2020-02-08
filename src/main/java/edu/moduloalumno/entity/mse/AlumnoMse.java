package edu.moduloalumno.entity.mse;

import java.io.Serializable;
import java.sql.Date;

public class AlumnoMse implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String codigoAlumno;
    private String dni;    
    private String apellidoPaterno;    
    private String apellidoMaterno;    
    private String nombre;
    private Date fechaNacimiento;    
    private String domicilioActual;    
    private String distrito;
    private String telefonoFijo;
    private String telefonoCelular;
    private String correoPersonal;
    private String correoLaboral;
    
    public AlumnoMse() {
		// TODO Auto-generated constructor stub
	}
    
    public void setCodigoAlumno(String codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}
    
    public String getCodigoAlumno() {
		return codigoAlumno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilioActual() {
		return domicilioActual;
	}

	public void setDomicilioActual(String domicilioActual) {
		this.domicilioActual = domicilioActual;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getCorreoPersonal() {
		return correoPersonal;
	}

	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}

	public String getCorreoLaboral() {
		return correoLaboral;
	}

	@Override
	public String toString() {
		return "Alumno2 [codigoAlumno=" + codigoAlumno + ", dni=" + dni + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", domicilioActual=" + domicilioActual + ", distrito=" + distrito + ", telefonoFijo=" + telefonoFijo
				+ ", telefonoCelular=" + telefonoCelular + ", correoPersonal=" + correoPersonal + ", correoLaboral="
				+ correoLaboral + "]";
	}

	public void setCorreoLaboral(String correoLaboral) {
		this.correoLaboral = correoLaboral;
	}
    
}
