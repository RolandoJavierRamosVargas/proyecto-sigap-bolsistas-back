package edu.moduloalumno.dao;

import edu.moduloalumno.entity.UsuarioJOINAlumnoPrograma;

public interface IUsuarioJOINAlumnoProgramaDAO {
	
	UsuarioJOINAlumnoPrograma getUsuarioJOINAlumnoProgramaByUserPass(String pass, String userName);
	UsuarioJOINAlumnoPrograma getUpdateUsuarioJOINAlumnoPrograma(String userName, String mail, String pass);
	UsuarioJOINAlumnoPrograma getResetUsuarioJOINAlumnoPrograma(String mail, String userName);

}
