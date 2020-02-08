package edu.moduloalumno.dao.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IUsuarioJOINAlumnoProgramaDAO;
import edu.moduloalumno.entity.Usuario;
import edu.moduloalumno.entity.UsuarioJOINAlumnoPrograma;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Transactional
@Repository
public class UsuarioJOINAlumnoProgramaDAOImpl implements IUsuarioJOINAlumnoProgramaDAO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UsuarioJOINAlumnoPrograma getUsuarioJOINAlumnoProgramaByUserPass(String pass, String userName) {
		System.out.println("pruebaaaa");

		String idUser = "SELECT id_usuario" + " from  usuario " + " where (user_name ='" + userName + "');";

		RowMapper<Usuario> rowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		Usuario use = jdbcTemplate.queryForObject(idUser, rowMapper);
		String id = Integer.toString(use.getIdUsuario());

		String pas1 = getMD5(pass+userName+id);
		
		System.out.println(pas1);
		
		String sql = "SELECT us.id_usuario, us.user_name, us.pass, ap.cod_alumno, ap.ape_paterno, ap.nom_alumno, ap.dni_m"
				+ " from  usuario us join alumno_programa ap " + " ON (us.user_name = ap.dni_m )"
				+ " where (us.user_name ='" + userName + "') and (us.pass ='" + pas1 + "' ) limit 1;";

		RowMapper<UsuarioJOINAlumnoPrograma> rowMap = new BeanPropertyRowMapper<UsuarioJOINAlumnoPrograma>(
				UsuarioJOINAlumnoPrograma.class);
		UsuarioJOINAlumnoPrograma usuarioJOINAlumnoPrograma = jdbcTemplate.queryForObject(sql, rowMap);
		return usuarioJOINAlumnoPrograma;
	}
	
	@Override
	public UsuarioJOINAlumnoPrograma getUpdateUsuarioJOINAlumnoPrograma(String userName, String mail, String pass) {
		
		UsuarioJOINAlumnoPrograma usuarioJOINAlumnoPrograma = null;
		
		String usuarioId= "SELECT us.id_usuario "
								+"from  usuario us join alumno_programa ap" + " ON (us.user_name = ap.dni_m )"
								+"where (ap.dni_m='" + userName + "') and (ap.correo ='" + mail + "' or ap.correo_personal = '" + mail + "' );";

		RowMapper<Usuario> rowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		Usuario use = jdbcTemplate.queryForObject(usuarioId, rowMapper);
		String id = Integer.toString(use.getIdUsuario());
		
		String sql = "UPDATE usuario SET pass = '"+pass+"'"
					+"WHERE (id_usuario = '" + id + "');";
		
		int i =jdbcTemplate.update(sql);
		
	    if(i == 1) {
			String sql2 = "SELECT us.id_usuario, us.user_name, us.pass, ap.cod_alumno, ap.ape_paterno, ap.nom_alumno, ap.dni_m"
					+ " from  usuario us join alumno_programa ap " + " ON (us.user_name = ap.dni_m )"
					+ " where (us.id_usuario ='" + id + "') ;";

			RowMapper<UsuarioJOINAlumnoPrograma> rowMap = new BeanPropertyRowMapper<UsuarioJOINAlumnoPrograma>(UsuarioJOINAlumnoPrograma.class);
			usuarioJOINAlumnoPrograma = jdbcTemplate.queryForObject(sql2, rowMap);
			
		}
		
		return usuarioJOINAlumnoPrograma;
		
	}
	
	
	@Override
	public UsuarioJOINAlumnoPrograma getResetUsuarioJOINAlumnoPrograma(String mail, String userName) {
		
		UsuarioJOINAlumnoPrograma usuarioJOINAlumnoPrograma = null;
		
		String usua = "SELECT us.id_usuario, us.user_name "
					  +" from  usuario us join alumno_programa ap" + " ON (us.user_name = ap.dni_m )"
					  +" where (ap.dni_m='" + userName + "') and (ap.correo ='" + mail + "' or ap.correo_personal = '" + mail + "'  );";
		
		RowMapper<Usuario> rowMa = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		Usuario use = jdbcTemplate.queryForObject(usua, rowMa);
		
		String id = Integer.toString(use.getIdUsuario());
		String ide = use.getUserName();
		
		String sql = " UPDATE usuario SET pass = '"+ide+"'"
					+" WHERE (user_name = '" + ide + "') and (id_usuario = ' " + id + "');";
		
		int i =jdbcTemplate.update(sql);
		
		System.out.println("Se modifico " + i + " usuarios");
		
		if(i == 1) {
			String sql3 = "SELECT us.id_usuario, us.user_name, us.pass, ap.cod_alumno, ap.ape_paterno, ap.nom_alumno, ap.dni_m"
					    + " FROM  usuario us JOIN alumno_programa ap " + " ON (us.user_name = ap.dni_m )"
					    + " WHERE  (us.user_name ='" + ide + "' );";
			RowMapper<UsuarioJOINAlumnoPrograma> rowMap = new BeanPropertyRowMapper<UsuarioJOINAlumnoPrograma>(UsuarioJOINAlumnoPrograma.class);
			usuarioJOINAlumnoPrograma = jdbcTemplate.queryForObject(sql3, rowMap);
			
		}
		
		return usuarioJOINAlumnoPrograma;
		
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
