package edu.moduloalumno.entity;

public class UsuarioJOINPerfil {
	
	private Integer idUsuario;
    
    private String userName;
    
    private String pass;
    
    private boolean estadoUp;
    
    private Integer idPerfil;
    
    public UsuarioJOINPerfil() {
    	
    }

	public UsuarioJOINPerfil(Integer idUsuario, String userName, String pass, boolean estadoUp, Integer idPerfil) {
		super();
		this.idUsuario = idUsuario;
		this.userName = userName;
		this.pass = pass;
		this.estadoUp = estadoUp;
		this.idPerfil = idPerfil;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isEstadoUp() {
		return estadoUp;
	}

	public void setEstadoUp(boolean estadoUp) {
		this.estadoUp = estadoUp;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
    
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime*result + ((idUsuario == null) ? 0: idUsuario.hashCode());
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
		UsuarioJOINPerfil other = (UsuarioJOINPerfil) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UsuarioJOINPerfil [idUsuario=" + idUsuario + ", userName=" + userName + ", pass="+ pass + 
			    ", estadoUp=" + estadoUp + ", idPerfil=" + idPerfil+"]";
	}
    

}

