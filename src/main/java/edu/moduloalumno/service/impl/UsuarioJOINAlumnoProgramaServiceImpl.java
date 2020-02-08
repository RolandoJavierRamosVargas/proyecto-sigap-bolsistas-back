package edu.moduloalumno.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.IUsuarioJOINAlumnoProgramaDAO;
import edu.moduloalumno.entity.UsuarioJOINAlumnoPrograma;
import edu.moduloalumno.service.IUsuarioJOINAlumnoProgramaService;

@Service
public class UsuarioJOINAlumnoProgramaServiceImpl implements IUsuarioJOINAlumnoProgramaService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUsuarioJOINAlumnoProgramaDAO usuarioJOINAlumnoProgramaDAO;

	@Override
	public UsuarioJOINAlumnoPrograma getUsuarioJOINAlumnoProgramaByUserPass(String pass, String userName) {
		UsuarioJOINAlumnoPrograma usuarioJOINAlumnoPrograma = usuarioJOINAlumnoProgramaDAO.getUsuarioJOINAlumnoProgramaByUserPass(pass, userName);
		return usuarioJOINAlumnoPrograma;
	}
	
	@Override
	public UsuarioJOINAlumnoPrograma getUpdateUsuarioJOINAlumnoPrograma(String userName, String mail, String pass) {
		UsuarioJOINAlumnoPrograma usuarioJOINAlumnoPrograma = usuarioJOINAlumnoProgramaDAO.getUpdateUsuarioJOINAlumnoPrograma(userName, mail, pass);
		return usuarioJOINAlumnoPrograma;
	}
	
	@Override
	public UsuarioJOINAlumnoPrograma getResetUsuarioJOINAlumnoPrograma(String mail, String userName) {
		UsuarioJOINAlumnoPrograma usuarioJOINAlumnoPrograma = usuarioJOINAlumnoProgramaDAO.getResetUsuarioJOINAlumnoPrograma(mail, userName);
		return usuarioJOINAlumnoPrograma;
	}

}
