package edu.moduloalumno.service;

import edu.moduloalumno.entity.UsuarioJOINPerfil;

public interface IUsuarioJOINPerfilService {
	
	UsuarioJOINPerfil getUsuarioJOINPerfilByUserPass(String userName, String pass);


}
