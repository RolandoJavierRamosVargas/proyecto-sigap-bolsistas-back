package edu.moduloalumno.dao.impl;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IUsuarioJOINPerfilDAO;
import edu.moduloalumno.entity.Usuario;
import edu.moduloalumno.entity.UsuarioJOINAlumnoPrograma;
import edu.moduloalumno.entity.UsuarioJOINPerfil;

@Transactional
@Repository
public class UsuarioJOINPerfilDAOImpl implements IUsuarioJOINPerfilDAO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UsuarioJOINPerfil getUsuarioJOINPerfilByUserPass(String userName, String pass) {
		System.out.println("pruebaaaa");
		System.out.println(userName);
		System.out.println(pass);

		String idUser = "SELECT id_usuario" + " from  usuario " + " where (user_name ='" + userName + "');";

		RowMapper<Usuario> rowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		Usuario use = jdbcTemplate.queryForObject(idUser, rowMapper);
		String id = Integer.toString(use.getIdUsuario());
		System.out.println(id);
		String pas1 = getMD5(pass+userName+id);
		System.out.println(pas1);
		String sql = "SELECT use.id_usuario, use.user_name, use.pass, up.estado_up, up.id_perfil"
					+ " from  usuario use join usuario_perfil up " + " ON (use.id_usuario = up.id_usuario)"
					+ " where (use.user_name ='" + userName + "') and (use.pass ='" + pas1 + "' );";
		
		System.out.println(sql);

		RowMapper<UsuarioJOINPerfil> rowMap = new BeanPropertyRowMapper<UsuarioJOINPerfil>(
				UsuarioJOINPerfil.class);
		UsuarioJOINPerfil usuarioJOINPerfil = jdbcTemplate.queryForObject(sql, rowMap);
		System.out.println(usuarioJOINPerfil);
		return usuarioJOINPerfil;
	}

	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}


