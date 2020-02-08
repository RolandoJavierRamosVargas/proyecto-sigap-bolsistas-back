package edu.moduloalumno.dao.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.mse.IAlumnoMseDAO;
import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.entity.mse.AlumnoMse;
import edu.moduloalumno.entity.mse.CmbProgramas;
import edu.moduloalumno.entity.mse.ConProgramaPorAlumno;
import edu.moduloalumno.rowmapper.AlumnoRowMapper;
import edu.moduloalumno.rowmapper.ProgramaRowMapper;
import edu.moduloalumno.rowmapper.mse.AlumnoMseRowMapper;
import edu.moduloalumno.rowmapper.mse.CmbProgramasRowMapper;
import edu.moduloalumno.rowmapper.mse.ConProgramaPorAlumnoRowMapper;

@Transactional
@Repository
public class AlumnoMseDAOImpl implements IAlumnoMseDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public AlumnoMse getAlumnoByCod(String codAlum) {
		//String sql = "SELECT dni_m, ape_paterno, ape_materno, nom_alumno, nac_fecha, ..., ..., telefono, telefono_movil, correo_personal, correo  FROM alumno_programa WHERE cod_alumno = ?";
		String sql = "SELECT cod_alumno, dni_m, ape_paterno, ape_materno, nom_alumno, nac_fecha, telefono, telefono_movil, correo_personal, correo FROM alumno_programa WHERE cod_alumno = '"+codAlum+"'";
		//RowMapper<Alumno2> rowMapper = new BeanPropertyRowMapper<Alumno2>(Alumno2.class);
		RowMapper<AlumnoMse> rowMapper = new AlumnoMseRowMapper();
		AlumnoMse a = this.jdbcTemplate.query(sql, rowMapper).get(0);
		System.out.println(a);
		return a;
	}

	@Override
	public void updateAlumno(AlumnoMse alumno) {
		//String sql = "UPDATE alumno_programa SET ape_paterno = ?, ape_materno = ?, nom_alumno = ?, nac_fecha = ? , ... = ?, ... = ? ,telefono = ?, telefono_movil = ?, correo_personal = ?, correo = ?  WHERE cod_alumno = ?";
		String sql = "UPDATE alumno_programa SET "
				+ "ape_paterno = '"+alumno.getApellidoPaterno()+"'"
				+ ", ape_materno = '"+alumno.getApellidoMaterno()+"'"
				+ ", nom_alumno = '"+alumno.getNombre()+"'"
				+ ", nac_fecha = ?"
				
				+ ", telefono = ?"
				+ ", telefono_movil = '"+alumno.getTelefonoCelular()+"'"
				+ ", correo_personal = '"+alumno.getCorreoPersonal()+"'"
				+ ", correo = '"+alumno.getCorreoLaboral()+"'"
				
				+ " WHERE cod_alumno = '"+alumno.getCodigoAlumno()+"'";
		System.out.println("query="+sql);
		jdbcTemplate.update(sql,alumno.getFechaNacimiento(),alumno.getTelefonoFijo());
		//ultimos cambios
		
	}
	
	@Override
	public List<ConProgramaPorAlumno> consultaProgramaPorAlumno(String codAlumno) {
		//String sql = "select a.cod_alumno , a.anio_ingreso, m.nom_programa , m.sigla_programa from programa m inner join alumno_programa a on m.id_programa = a.id_programa where a.dni_m = '25748054'";
		String sql = "select a.cod_alumno , a.anio_ingreso, m.nom_programa , m.sigla_programa from programa m inner join alumno_programa a on m.id_programa = a.id_programa where a.dni_m = '"+codAlumno+"'";
		System.out.println("CODIGO SQL = "+ sql);
		RowMapper<ConProgramaPorAlumno> rowMapper = new ConProgramaPorAlumnoRowMapper();
		List<ConProgramaPorAlumno> a = this.jdbcTemplate.query(sql, rowMapper);
		System.out.println(a);
		return a;
	}

	@Override
	public List<CmbProgramas> consultaListaProgramas(String codigo) {
		String sql = "SELECT distinct m.id_programa,m.nom_programa from programa m inner join alumno_programa a on m.id_programa = a.id_programa " + 
				" where m.nom_programa NOT IN (select m.nom_programa from programa m " + 
				" inner join alumno_programa a on m.id_programa = a.id_programa " + 
				" where a.dni_m = '"+codigo+"')";
		System.out.println("CODIGO SQL = "+ sql);
		RowMapper<CmbProgramas> rowMapper = new CmbProgramasRowMapper();
		List<CmbProgramas> a = this.jdbcTemplate.query(sql, rowMapper);
		System.out.println(a);
		return a;
	}

}