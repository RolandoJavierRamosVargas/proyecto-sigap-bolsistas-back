package edu.moduloalumno.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.UsuarioJOINPerfil;


public class UsuarioJOINPerfilRowMapper implements RowMapper<UsuarioJOINPerfil>{

	@Override
	public UsuarioJOINPerfil mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsuarioJOINPerfil usuarioJOINPerfil = new UsuarioJOINPerfil();
		usuarioJOINPerfil.setIdUsuario(rs.getInt("id_usuario"));
		usuarioJOINPerfil.setUserName(rs.getString("user_name"));
		usuarioJOINPerfil.setPass(rs.getString("pass"));
		usuarioJOINPerfil.setEstadoUp(rs.getBoolean("estado_up"));
		usuarioJOINPerfil.setPerfil(rs.getInt("id_perfil"));
		return usuarioJOINPerfil;
	}

}
