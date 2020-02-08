package edu.moduloalumno.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.IUsuarioJOINPerfilDAO;
import edu.moduloalumno.entity.UsuarioJOINPerfil;
import edu.moduloalumno.service.IUsuarioJOINPerfilService;



@Service
public class UsuarioJOINPerfilServiceImpl implements IUsuarioJOINPerfilService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUsuarioJOINPerfilDAO usarioJOINPerfilDAO;

	@Override
	public UsuarioJOINPerfil getUsuarioJOINPerfilByUserPass(String userName, String pass) {
		UsuarioJOINPerfil usuarioJOINPerfil = usarioJOINPerfilDAO.getUsuarioJOINPerfilByUserPass(userName, pass);
		return usuarioJOINPerfil;
	}

	
	

	
}


