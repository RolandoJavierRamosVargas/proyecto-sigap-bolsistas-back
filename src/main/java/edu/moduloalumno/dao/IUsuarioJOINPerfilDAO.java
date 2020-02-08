package edu.moduloalumno.dao;

import edu.moduloalumno.entity.UsuarioJOINPerfil;

public interface IUsuarioJOINPerfilDAO {
	
	UsuarioJOINPerfil getUsuarioJOINPerfilByUserPass(String userName, String pass);

}

