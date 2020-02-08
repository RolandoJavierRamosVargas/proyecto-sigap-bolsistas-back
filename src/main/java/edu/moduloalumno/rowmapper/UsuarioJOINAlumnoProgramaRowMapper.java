package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.UsuarioJOINAlumnoPrograma;

public class UsuarioJOINAlumnoProgramaRowMapper implements RowMapper<UsuarioJOINAlumnoPrograma> {

	@Override
	public UsuarioJOINAlumnoPrograma mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsuarioJOINAlumnoPrograma usuarioJOINAlumnoPrograma = new UsuarioJOINAlumnoPrograma();
		usuarioJOINAlumnoPrograma.setIdUsuario(rs.getInt("id_usuario"));
		usuarioJOINAlumnoPrograma.setUserName(rs.getString("user_name"));
		usuarioJOINAlumnoPrograma.setPass(rs.getString("pass"));
		usuarioJOINAlumnoPrograma.setCodAlumno(rs.getString("cod_alumno"));
		usuarioJOINAlumnoPrograma.setApePaterno(rs.getString("ape_paterno"));
		usuarioJOINAlumnoPrograma.setNomAlumno(rs.getString("nom_alumno"));
		usuarioJOINAlumnoPrograma.setDniM(rs.getString("dni_m"));
		usuarioJOINAlumnoPrograma.setMail(rs.getString("correo"));
		return usuarioJOINAlumnoPrograma;
	}

}
