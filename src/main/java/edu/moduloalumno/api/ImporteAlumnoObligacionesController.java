package edu.moduloalumno.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.dao.impl.ImporteAlumnoObligacionesDAOImpl;
import edu.moduloalumno.entity.Alumno;
import edu.moduloalumno.entity.ImporteAlumnoObligaciones;
import edu.moduloalumno.service.IImporteAlumnoObligacionesService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/importealumnoobligaciones")
public class ImporteAlumnoObligacionesController {
		
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IImporteAlumnoObligacionesService service;
	private ImporteAlumnoObligacionesDAOImpl dao;
    		
        @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ImporteAlumnoObligaciones>> getAllImporteAlumnosObligaciones() {
		logger.info("> getAllImporteAlumnosObligaciones [ImporteAlumnoObligaciones]");

		List<ImporteAlumnoObligaciones> list = null;
		try {
			list = service.getAllImporteAlumnosObligaciones();

			if (list == null) {
				list = new ArrayList<ImporteAlumnoObligaciones>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<ImporteAlumnoObligaciones>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllImporteAlumnosObligaciones [ImporteAlumnoObligaciones]");
		return new ResponseEntity<List<ImporteAlumnoObligaciones>>(list, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/search/{cod_alumno}/{cod_programa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    	public ResponseEntity<List<ImporteAlumnoObligaciones>> getImporteAlumnoObligacionesImporte(@PathVariable("cod_alumno") Integer cod_alumno,@PathVariable("cod_programa") Integer cod_programa) {
    		logger.info("> getImporteAlumnoObligacionesImporte [ImporteAlumnoObligaciones]");
    		
    		List<ImporteAlumnoObligaciones> list = null;
    		
    		try {
    			list = service.getImporteAlumnoObligacionesImporte(cod_alumno, cod_programa);
    			
    			if (list == null) {
    				list = new ArrayList<ImporteAlumnoObligaciones>();
    			}
    		} catch (Exception e) {
    			logger.error("Unexpected Exception caught.", e);
    			return new ResponseEntity<List<ImporteAlumnoObligaciones>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    		

    		logger.info("< getImporteAlumnoObligacionesImporte [ImporteAlumnoObligaciones]");
    		return new ResponseEntity<List<ImporteAlumnoObligaciones>>(list, HttpStatus.OK);
    	} 
        
        @PostMapping(value = "/add", consumes = "application/json",produces = "application/json")
    	public ImporteAlumnoObligaciones add(@RequestBody ImporteAlumnoObligaciones importealumnoobligaciones){
        	
        	service.addImporteAlumnoObligaciones(importealumnoobligaciones);
        	return importealumnoobligaciones;
    	}
        
        @PostMapping(value = "/update", consumes = "application/json",produces = "application/json")
    	public ImporteAlumnoObligaciones update(@RequestBody ImporteAlumnoObligaciones newimportealumnoobligaciones){
        	
        	service.updateImporteAlumnoObligaciones(newimportealumnoobligaciones);
        	return newimportealumnoobligaciones;
    	}


}
