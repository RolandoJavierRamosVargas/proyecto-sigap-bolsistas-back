package edu.moduloalumno.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.component.FloatFormat;
import edu.moduloalumno.entity.UsuarioJOINAlumnoPrograma;
import edu.moduloalumno.entity.UsuarioJOINPerfil;
import edu.moduloalumno.service.IUsuarioJOINPerfilService;

@RestController
@RequestMapping("/usuario/perfil")
public class UsuarioJOINPerfilController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("floatformat")
	private FloatFormat floatformat;
	
	@Autowired
	private IUsuarioJOINPerfilService usuarioJOINPerfilService;
	
	@RequestMapping(value = "/buscar/{userName}/{pass}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioJOINPerfil> getUsuarioJOINPerfilByUserPass(@PathVariable("userName") String userName, @PathVariable("pass") String pass) {
		logger.info("> getUsuarioJOINPerfilByUserPass [UsuarioJOINPerfil]");

		UsuarioJOINPerfil usuario = null;
		try {	
			
			usuario = usuarioJOINPerfilService.getUsuarioJOINPerfilByUserPass(userName, pass);
			System.out.println(usuario);
			if (usuario == null) {
				usuario = new UsuarioJOINPerfil();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<UsuarioJOINPerfil>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getUsuarioJOINAlumnoProgramaByUserPass [UsuarioJOINPerfil]");
		return new ResponseEntity<UsuarioJOINPerfil>(usuario, HttpStatus.OK);
	}

}


