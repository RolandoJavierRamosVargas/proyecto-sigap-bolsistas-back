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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.Alumno;
import edu.moduloalumno.entity.ImporteAlumno;
import edu.moduloalumno.service.IImporteAlumnoService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/importealumno")
public class ImporteAlumnoController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IImporteAlumnoService service;

	@RequestMapping(value = "/buscar/{cod_alumno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImporteAlumno> getImporteAlumnoByAlumnoId(@PathVariable("cod_alumno") Integer cod_alumno) {
		logger.info("> getImporteAlumnoByAlumnoId [ImporteAlumno]");

		ImporteAlumno impor = null;
		try {
			impor = service.getImporteAlumnoByAlumnoId(cod_alumno);

			if (impor == null) {
				impor = new ImporteAlumno();
			}

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<ImporteAlumno>(impor, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getImporteAlumnoById [ImporteAlumno]");
		return new ResponseEntity<ImporteAlumno>(impor, HttpStatus.OK);
	}

	@RequestMapping(value = "/search/{cod_alumno}/{cod_programa}/{cod_concepto}/{id_tipo_recaudacion}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImporteAlumno> getImporteAlumnoImporte(@PathVariable("cod_alumno") String cod_alumno,
			@PathVariable("cod_programa") Integer cod_programa, @PathVariable("cod_concepto") Integer cod_concepto,
			@PathVariable("id_tipo_recaudacion") Integer id_tipo_recaudacion) {
		logger.info("> getImporteAlumnoImporte [ImporteAlumno]");
		System.out.println("Entro al importe del alumno");
		ImporteAlumno importe = null;

		try {
			importe = service.getImporteAlumnoImporte(cod_alumno, cod_programa, cod_concepto,id_tipo_recaudacion);

			if (importe == null) {
				importe = new ImporteAlumno();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<ImporteAlumno>(importe, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getImporteAlumnoImporte [ImporteAlumno]");
		return new ResponseEntity<ImporteAlumno>(importe, HttpStatus.OK);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ImporteAlumno>> getAllImporteAlumnos() {
		logger.info("> getAllImporteAlumnos [ImporteAlumno]");

		List<ImporteAlumno> list = null;
		try {
			list = service.getAllImporteAlumnos();

			if (list == null) {
				list = new ArrayList<ImporteAlumno>();
			}

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<ImporteAlumno>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllImporteAlumnos [ImporteAlumno]");
		return new ResponseEntity<List<ImporteAlumno>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/filtrarimporte", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> getImporteAlumno(@RequestBody ImporteAlumno importealumno) {
		logger.info("> getImporteAlumno [ImporteAlumno]");

		System.out.println("LLEGA HASTA API");
		double importe = 0;
		try {
			importe = service.getImporteAlumno(importealumno);

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Double>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getImporteAlumno [ImporteAlumno]");
		return new ResponseEntity<Double>(importe, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImporteAlumno> addImporteAlumno(@RequestBody ImporteAlumno importealumno) {

		logger.info("> addImporteAlumno [ImporteAlumno]");
		logger.info("El importe enviado es "+importealumno + " < ");
		// ImporteAlumno newImporteAlumno = null;

		try {
			service.addImporteAlumno(importealumno);
		} catch (Exception e) {
			return new ResponseEntity<ImporteAlumno>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("> addImporteAlumno [ImporteAlumno]");
		return new ResponseEntity<ImporteAlumno>(importealumno, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImporteAlumno> updateImporteAlumno(@RequestBody ImporteAlumno newimportealumno) {

		logger.info("> updateImporteAlumno [ImporteAlumno]");
		System.out.println(newimportealumno);

		String coalu = newimportealumno.getCod_alumno();
		int copro = newimportealumno.getCod_programa();
		int cocon = newimportealumno.getCod_concepto();
		double im = newimportealumno.getImporte();
		Integer id_tipo_recaudacion  = newimportealumno.getId_tipo_recaudacion();
		String id_moneda =  newimportealumno.getId_moneda();

		ImporteAlumno importealumno = new ImporteAlumno(coalu, copro, cocon, im,id_tipo_recaudacion,id_moneda);

		try {
			service.updateImporteAlumno(importealumno);

		} catch (Exception e) {
			return new ResponseEntity<ImporteAlumno>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("> updateImporteAlumno [ImporteAlumno]");
		return new ResponseEntity<ImporteAlumno>(importealumno, HttpStatus.CREATED);
	}

}
