package edu.moduloalumno.api;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.CuentasPorCobrar;
import edu.moduloalumno.entity.CuentasPorCobrar2;
import edu.moduloalumno.entity.DeudoresPosgradoMasInfo;
import edu.moduloalumno.entity.Recaudaciones;
import edu.moduloalumno.model.Filtro;
import edu.moduloalumno.service.IRecaudacionesService;
import edu.moduloalumno.util.Operaciones;

@RestController
@RequestMapping("/recaudaciones")
public class RecaudacionesController {
//hola
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IRecaudacionesService recaudacionesService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recaudaciones>> getAllRecaudaciones() {
		logger.info("> getAllRecaudaciones [Recaudaciones]");

		List<Recaudaciones> list = null;
		try {
			list = recaudacionesService.getAllRecaudaciones();

			if (list == null) {
				list = new ArrayList<Recaudaciones>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllRecaudaciones [Recaudaciones]");
		return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.OK);
	}
	
	
	/* loco*/ 
	@RequestMapping(value = "/rec/{recibo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recaudaciones>> getRecaudacionReci(@PathVariable("recibo") String recibo) {
		logger.info("> getAllRecaudaciones [Recaudaciones]");
		
		List<Recaudaciones> list = null;

		try {
//			System.out.println("nro recibo = " + recibo);
			list = recaudacionesService.getRecaudacionReci(recibo);
			if (list == null) {
				list = new ArrayList<Recaudaciones>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getRecaudacionesByNomApe [Recaudaciones]");
//		System.out.println("retornando: "+list);
		return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.OK);

	}
	
	
	
	@RequestMapping(value = "/listar/{nomApe}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recaudaciones>> getRecaudacionesByNomApe(@PathVariable("nomApe") String nomApe) {
		logger.info("> getRecaudacionesByNomApe [Recaudaciones]");

		List<Recaudaciones> list = null;

		try {

			list = recaudacionesService.getRecaudacionesByNomApe(nomApe);
			if (list == null) {
				list = new ArrayList<Recaudaciones>();
			}

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getRecaudacionesByNomApe [Recaudaciones]");
		return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/listar/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recaudaciones>> getRecaudacionesByStartDateBetween(@PathVariable("fechaInicial") String fechaInicial,
			@PathVariable("fechaFinal") String fechaFinal) {
		logger.info("> getRecaudacionesByStartDateBetween [Recaudaciones]");

		List<Recaudaciones> list = null;
		Date fInicial;
		Date fFinal;

		DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");

		try {

			fInicial = formateador.parse(fechaInicial);
			fFinal = formateador.parse(fechaFinal);

			list = recaudacionesService.getRecaudacionesByStartDateBetween(fInicial, fFinal);

			if (list == null) {
				list = new ArrayList<Recaudaciones>();
			}

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getRecaudacionesByStartDateBetween [Recaudaciones]");
		return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/listar/{nom_ape}/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recaudaciones>> getRecaudacionesByNomApeStartDateBetween(@PathVariable("nom_ape") String nom_ape,
			@PathVariable("fechaInicial") String fechaInicial, @PathVariable("fechaFinal") String fechaFinal) {
		logger.info("> getRecaudacionesByNomApeStartDateBetween [Recaudaciones]");

		List<Recaudaciones> list = null;
		Date fInicial;
		Date fFinal;

		DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");

		try {

			fInicial = formateador.parse(fechaInicial);
			fFinal = formateador.parse(fechaFinal);

			list = recaudacionesService.getRecaudacionesByNomApeStartDateBetween(nom_ape, fInicial, fFinal);

			if (list == null) {
				list = new ArrayList<Recaudaciones>();
			}

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getRecaudacionesByNomApeStartDateBetween [Recaudaciones]");
		return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/listar/filtrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recaudaciones>> getRecaudacionesByFilter(@RequestBody Filtro filtro) {
		logger.info("> filterByAlumno [Recaudaciones]");

		String fechaFinal = filtro.getFechaFinal();

		String nom_ape = filtro.getNom_ape();

		String fechaInicial = filtro.getFechaInicial();

		String[] conceptos = filtro.getConceptos();

		String[] recibos = filtro.getRecibos();

		List<Recaudaciones> list01 = new ArrayList<Recaudaciones>();
		List<Recaudaciones> list02 = new ArrayList<Recaudaciones>();
		List<Recaudaciones> list03 = null;

		Date fInicial;
		Date fFinal;

		DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");

		Operaciones operacion = new Operaciones();

		try {

			for (String concepto : conceptos) {
				list01 = operacion.union(list01,
						recaudacionesService.getRecaudacionesByNomApeConcepto(concepto, nom_ape));
			}

			logger.info("LISTA DE RECAUDACIONES POR CONCEPTO: \n" + list01);

			for (String recibo : recibos) {
				list02 = operacion.union(list02, recaudacionesService.getRecaudacionesByNomApeRecibo(recibo, nom_ape));
			}

			logger.info("LISTA DE RECAUDACIONES POR RECIBOS: \n" + list02);

			fInicial = formateador.parse(fechaInicial);
			fFinal = formateador.parse(fechaFinal);

			list03 = recaudacionesService.getRecaudacionesByNomApeStartDateBetween(nom_ape, fInicial, fFinal);

			if (list03 == null) {
				list03 = new ArrayList<Recaudaciones>();
			}

			logger.info("LISTA DE RECAUDACIONES POR FECHAS: \n" + list03);

			list03 = operacion.intersection(list03, conceptos.length != 0 ? list01 : list03);
			list03 = operacion.intersection(list03, recibos.length != 0 ? list02 : list03);

		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Recaudaciones>>(list03, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< filterByAlumno [Recaudaciones]");
		return new ResponseEntity<List<Recaudaciones>>(list03, HttpStatus.OK);
	}

	 @RequestMapping(value = "/actualizar/{id_rec}/{cod_alumno}/{id_programa}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
        public void updateRecaudaciones(@PathVariable("id_rec") Integer id_rec, @PathVariable("cod_alumno") String cod_alumno, @PathVariable("id_programa") Integer id_programa){
            
            logger.info("> Commo00n: " + id_rec + " " + cod_alumno + " " + id_programa);
            Integer response = 0;
            
            try{
                 recaudacionesService.updateRecaudaciones(id_rec, cod_alumno, id_programa);
            } catch(Exception e){
                logger.error("Unexpected Exception caught. "+ e.getMessage());
            }
            
        } 
	 @RequestMapping(value = "/desasignar/{id_rec}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	 																		  
     public void desasignarRecaudaciones(@PathVariable("id_rec") Integer id_rec){
//         System.out.print("DESASIGNANDO: ");
//         System.out.println(id_rec);
//         logger.info("> Desasignando: " + id_rec );
         
         try{
              recaudacionesService.updateRecaudaciones(id_rec, null, null);
         } catch(Exception e){
             logger.error("Unexpected Exception caught. "+ e.getMessage());
         }
         
     } 

	 @RequestMapping(value = "/listarPendientes/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Recaudaciones>> getRecaudacionesPendientesByStartDateBetween(@PathVariable("fechaInicial") String fechaInicial,
				@PathVariable("fechaFinal") String fechaFinal) {
		 
//		 System.out.print("BUSCANDO PENDIENTES: ");

			List<Recaudaciones> list = null;
			Date fInicial;
			Date fFinal;

			DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");

			try {

				fInicial = formateador.parse(fechaInicial);
				fFinal = formateador.parse(fechaFinal);

				list = recaudacionesService.getRecaudacionesPendiengesEntreFechas(fInicial, fFinal);

				if (list == null) {
					list = new ArrayList<Recaudaciones>();
				}

			} catch (Exception e) {
				logger.error("Unexpected Exception caught.", e);
				return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
			}

//			logger.info("< getRecaudacionesByStartDateBetween [Recaudaciones]");
			return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.OK);
		}
	 
		@RequestMapping(value = "/listar/NombreApellido/{nomApe}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Recaudaciones>> getRecaudacionesPorNombreApellido(@PathVariable("nomApe") String nomApe) {
			nomApe = nomApe.toUpperCase();
			logger.info("> getRecaudacionesPorNombreApellido " + nomApe);

			List<Recaudaciones> list = null;

			try {

				list = recaudacionesService.getRecaudacionesPorNombre(nomApe);
				if (list == null) {
					list = new ArrayList<Recaudaciones>();
				}

			} catch (Exception e) {
				logger.error("Unexpected Exception caught.", e);
				return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			logger.info("< getRecaudacionesByNomApe [Recaudaciones]");
			return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.OK);
		}

		@RequestMapping(value = "/listarObservaciones/{fechaInicial}/{fechaFinal}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Recaudaciones>> getObservacionesByDate(@PathVariable("fechaInicial") String fechaInicial,
				@PathVariable("fechaFinal") String fechaFinal) {
		 
//		 System.out.print("BUSCANDO PENDIENTES: ");

			List<Recaudaciones> list = null;
			Date fInicial;
			Date fFinal;

			DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");

			try {

				fInicial = formateador.parse(fechaInicial);
				fFinal = formateador.parse(fechaFinal);

				list = recaudacionesService.getObservacionesEntreFechas(fInicial, fFinal);

				if (list == null) {
					list = new ArrayList<Recaudaciones>();
				}

			} catch (Exception e) {
				logger.error("Unexpected Exception caught.", e);
				return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
			}

//			logger.info("< getRecaudacionesByStartDateBetween [Recaudaciones]");
			return new ResponseEntity<List<Recaudaciones>>(list, HttpStatus.OK);
		}
		
		@RequestMapping(value="/cuentasPorCobrar/{fechaInicial}/{fechaFinal}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<CuentasPorCobrar>> getCuentasPorCobrar(@PathVariable("fechaInicial") String fechaInicial,@PathVariable("fechaFinal") String fechaFinal){
			System.out.println("Entro a cuentas por cobrar");
			
			List<CuentasPorCobrar> list=null;
			Date fInicial;
			Date fFinal;
			DateFormat formateador=new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				fInicial=formateador.parse(fechaFinal);
				System.out.println(fInicial);
				fFinal=formateador.parse(fechaFinal);
				System.out.println(fFinal);
				
				list=recaudacionesService.getCuentasPorCobrar(fechaInicial.substring(0, 4),fechaFinal.substring(0,4));
				System.out.println(list);
				if(list==null) {
					list=new ArrayList<CuentasPorCobrar>();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ResponseEntity<List<CuentasPorCobrar>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return new ResponseEntity<List<CuentasPorCobrar>>(list,HttpStatus.OK);
		}
		/*Esta es la segunda version de cuentas por cobrar (CPCv2)*/
		@RequestMapping(value="/cuentasPorCobrar2/{fechaInicial}/{fechaFinal}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<DeudoresPosgradoMasInfo>> getCuentasPorCobrar2(@PathVariable("fechaInicial") String fechaInicial,@PathVariable("fechaFinal") String fechaFinal){
			System.out.println("Entro a cuentas por cobrar");
			
			List<DeudoresPosgradoMasInfo> list=null;
			
			try {	
				
				list=recaudacionesService.getCuentasPorCobrar2(fechaInicial.substring(0, 4),fechaFinal.substring(0,4));
				System.out.println(list);
				if(list==null) {
					list=new ArrayList<DeudoresPosgradoMasInfo>();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Entro al catch");
				return new ResponseEntity<List<DeudoresPosgradoMasInfo>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return new ResponseEntity<List<DeudoresPosgradoMasInfo>>(list,HttpStatus.OK);
		}
		
		/*Fin de la segunda version de cuentas por cobrar (CPCv2)*/
		
		@RequestMapping(value="/cuentasPorCobrar/exportExcel/{fechaInicial}/{fechaFinal}",method=RequestMethod.GET)
		public  ResponseEntity<InputStreamResource> exportExcel(@PathVariable("fechaInicial") String fechaInicial,@PathVariable("fechaFinal") String fechaFinal) throws Exception{
			
			ByteArrayInputStream stream = recaudacionesService.exportAllData(fechaInicial.substring(0, 4), fechaFinal.substring(0, 4));

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=recaudaciones.xls");

			return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
			
		}
		
		
		@RequestMapping(value="/cuentasPorCobrar2/exportExcelMasInfoPersonal/{fechaInicial}/{fechaFinal}",method=RequestMethod.GET)
		public  ResponseEntity<InputStreamResource> exportExcelMasInfoPersonal(@PathVariable("fechaInicial") String fechaInicial,@PathVariable("fechaFinal") String fechaFinal) throws Exception{
			
			ByteArrayInputStream stream = recaudacionesService.exportAllDataMasInfo(fechaInicial.substring(0, 4), fechaFinal.substring(0, 4));

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=deudasMasInfo.xls");

			return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
			
		}
		
		
		
		
		
}