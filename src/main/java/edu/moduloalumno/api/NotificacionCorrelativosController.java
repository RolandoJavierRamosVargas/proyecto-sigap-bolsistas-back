package edu.moduloalumno.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.ImporteAlumnoObligaciones;
import edu.moduloalumno.entity.NotificacionCorrelativo;
import edu.moduloalumno.entity.mse.AlumnoMse;
import edu.moduloalumno.service.INotificacionCorrelativoService;

@RestController
@RequestMapping("/notificacion_correlativos")
public class NotificacionCorrelativosController {
	
	@Autowired
	private INotificacionCorrelativoService notifiCorre;
	
	@GetMapping("/listar")
	public ResponseEntity<List<NotificacionCorrelativo>> getNotificacionCorrelativos(){
		
		List<NotificacionCorrelativo> notificacion=null;
		
		try {
			notificacion=notifiCorre.getNotificacionCorrelativos();
			if(notificacion==null) {
				return null;
			}
		} catch (Exception e) {
			return new ResponseEntity<List<NotificacionCorrelativo>>(notificacion, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		return new ResponseEntity<List<NotificacionCorrelativo>>(notificacion, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCorrelativo(@RequestBody NotificacionCorrelativo notifiCorrelativo){
		System.out.println("Notificacion ");
		System.out.println(notifiCorrelativo);
		try {
			notifiCorre.actualizarNotifiCorrelativo(notifiCorrelativo);				
		} catch (Exception e) {
			System.out.println("No se actualizo");
			
		}
		System.out.println("se actualizo");
	}

}
