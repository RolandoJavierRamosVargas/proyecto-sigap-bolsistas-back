package edu.moduloalumno.dao.impl;

import java.sql.PreparedStatement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IImporteAlumnoDAO;
import edu.moduloalumno.entity.ImporteAlumno;
import edu.moduloalumno.rowmapper.ImporteAlumnoRowMapper;

@Transactional    
@Repository
public class ImporteAlumnoDAOImpl implements IImporteAlumnoDAO{
        @Autowired
	private JdbcTemplate jdbcTemplate;
        
        @Override
	public ImporteAlumno getImporteAlumnoByAlumnoId(int cod_alumno) {
		String sql = "SELECT cod_alumno, cod_programa, cod_concepto, importe FROM importe_alumno WHERE cod_alumno = ?";
		RowMapper<ImporteAlumno> rowMapper = new BeanPropertyRowMapper<ImporteAlumno>(ImporteAlumno.class);
		ImporteAlumno importealumno = jdbcTemplate.queryForObject(sql, rowMapper, cod_alumno);
		return importealumno;
	}
        
        @Override
    	public ImporteAlumno getImporteAlumnoImporte(int cod_alumno,int cod_programa, int cod_concepto) {
    		String sql = "SELECT cod_alumno, cod_programa, cod_concepto, importe FROM importe_alumno WHERE cod_alumno = ? and cod_programa = ? and cod_concepto = ?";
    		RowMapper<ImporteAlumno> rowMapper = new BeanPropertyRowMapper<ImporteAlumno>(ImporteAlumno.class);
    		ImporteAlumno importealumno = jdbcTemplate.queryForObject(sql, rowMapper, cod_alumno,cod_programa,cod_concepto);
    		return importealumno;
    	}
        
        @Override
    	public double getImporteAlumno(ImporteAlumno importealumno) {
        	System.out.println("LLEGA HASTA DAOIMP");
    		String sql = "SELECT importe FROM importe_alumno WHERE cod_alumno = ? and cod_programa = ? and cod_concepto = ?";
    		//RowMapper<ImporteAlumno> rowMapper = new BeanPropertyRowMapper<ImporteAlumno>(ImporteAlumno.class);
    		double importe = jdbcTemplate.queryForObject(sql, Double.class,importealumno.getImporte());
    		return importe;
    	}
    
        @Override
	public List<ImporteAlumno> getAllImporteAlumnos() {
		String sql = "SELECT cod_alumno, cod_programa, cod_concepto, importe FROM importe_alumno";
		
		RowMapper<ImporteAlumno> rowMapper = new ImporteAlumnoRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
        
        @Override
	public void addImporteAlumno(ImporteAlumno importealumno) {
		// Add ImporteAlumno
		String sql = "INSERT INTO importe_alumno (cod_alumno, cod_programa, cod_concepto, importe) values (?,?, ?,?)";
	    jdbcTemplate.update(sql,importealumno.getCod_alumno(),importealumno.getCod_programa(),importealumno.getCod_concepto(),importealumno.getImporte());
		/*
	    KeyHolder keyHolder = new GeneratedKeyHolder();
	    
	    jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(sql);
	          ps.setInt(1,importealumno.getCod_alumno());
	          ps.setInt(2,importealumno.getCod_programa());
	          ps.setInt(3,importealumno.getCod_concepto());
	          ps.setDouble(4,importealumno.getImporte());
	          return ps;
	        }, keyHolder);
	    */
	}
        
        @Override
	public void updateImporteAlumno(ImporteAlumno importealumno) {
		String sql = "UPDATE importe_alumno SET importe = ? WHERE cod_alumno = ? and cod_programa = ? and cod_concepto = ?";
		jdbcTemplate.update(sql,importealumno.getImporte(),importealumno.getCod_alumno(),importealumno.getCod_programa(),importealumno.getCod_concepto());
    }
        
        @Override
	public void deleteImporteAlumno(int cod_alumno) {
		String sql = "DELETE FROM importe_alumno WHERE cod_alumno = ?";
		jdbcTemplate.update(sql, cod_alumno);
	}
}
