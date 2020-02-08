package edu.moduloalumno.api.mse;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.Programa;
import edu.moduloalumno.entity.mse.AlumnoMse;
import edu.moduloalumno.entity.mse.CmbProgramas;
import edu.moduloalumno.entity.mse.ConProgramaPorAlumno;
import edu.moduloalumno.service.mse.IAlumnoService;

@RestController
@RequestMapping("/mse/alumno")
public class AlumnoMseController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAlumnoService service;
	
	@RequestMapping(value = "/buscar/{idAlum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlumnoMse> getAlumnoById(@PathVariable("idAlum") String codAlumn) {
		System.out.println("ENTRO A ALUMNO2 + codigo= " + codAlumn);
		AlumnoMse alu = null;
		try {
			alu = service.getAlumnoByCod(codAlumn);

			if (alu == null) {
				alu = new AlumnoMse();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<AlumnoMse>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<AlumnoMse>(alu, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/conProgramaPorCodigo/{idAlum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ConProgramaPorAlumno>> conProgramaPorCodigo(@PathVariable("idAlum") String codAlumn) {
		System.out.println("ENTRO A ConProgramaPorAlumno+ codigo= " + codAlumn);
		List<ConProgramaPorAlumno> alu = null;
		try {
			alu = service.conProgramaPorCodigo(codAlumn);

			if (alu == null) {
				alu = null;
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<ConProgramaPorAlumno>>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<ConProgramaPorAlumno>>(alu, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/conProgramas/{idAlum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CmbProgramas>> conProgramas(@PathVariable("idAlum") String codAlumn) {
		System.out.println("ENTRO A ConsultasPrograma+ codigo= " + codAlumn);
		List<CmbProgramas> alu = null;
		try {
			alu = service.consultaProgramas(codAlumn);

			if (alu == null) {
				alu = null;
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<CmbProgramas>>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<CmbProgramas>>(alu, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlumnoMse> update(@RequestBody AlumnoMse alumno) {
		System.out.println("Ingreso update");
		System.out.println(alumno);
		try {
			service.updateAlumno(alumno);				
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<AlumnoMse>(alumno, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<AlumnoMse>(alumno, HttpStatus.OK);
	}

	
}
