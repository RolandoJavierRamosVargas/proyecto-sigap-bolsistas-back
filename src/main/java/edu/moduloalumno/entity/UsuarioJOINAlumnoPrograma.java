package edu.moduloalumno.entity;

public class UsuarioJOINAlumnoPrograma {

	private Integer idUsuario;

	private String userName;

	private String pass;

	private String codAlumno;

	private String apePaterno;

	private String nomAlumno;

	private String dniM;

	private String mail;

	public UsuarioJOINAlumnoPrograma() {
		super();
		
	}

	public UsuarioJOINAlumnoPrograma(Integer idUsuario, String userName, String pass, String codAlumno,
			String apePaterno, String nomAlumno, String dniM, String mail) {
		super();
		this.idUsuario = idUsuario;
		this.userName = userName;
		this.pass = pass;
		this.codAlumno = codAlumno;
		this.apePaterno = apePaterno;
		this.nomAlumno = nomAlumno;
		this.dniM = dniM;
		this.mail = mail;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getNomAlumno() {
		return nomAlumno;
	}

	public void setNomAlumno(String nomAlumno) {
		this.nomAlumno = nomAlumno;
	}

	public String getDniM() {
		return dniM;
	}

	public void setDniM(String dniM) {
		this.dniM = dniM;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioJOINAlumnoPrograma other = (UsuarioJOINAlumnoPrograma) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UsuarioJOINAlumnoPrograma [idUsuario=" + idUsuario + ", userName=" + userName + ", pass="+ pass + 
			    ", codAlumno=" + codAlumno + ", apePaterno=" + apePaterno + ", nomAlumno=" + nomAlumno+ 
			    ", dniM="+ dniM +", mail="+mail+"]";
	}
	

}

