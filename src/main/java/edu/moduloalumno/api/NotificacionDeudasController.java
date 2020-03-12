package edu.moduloalumno.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.NotificacionCorrelativo;
import edu.moduloalumno.entity.NotificacionDeudas;
import edu.moduloalumno.service.INotificacionCorrelativoService;
import edu.moduloalumno.service.INotificacionDeudasService;

@RestController
@RequestMapping("/notificacion_deudas")
public class NotificacionDeudasController {

	@Autowired
	private INotificacionDeudasService notifiDeudas;
	
	
	@RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertarNotificacionDeudas(@RequestBody NotificacionDeudas notifiDeudas){
		System.out.println("Notificacion Deudas ");
		System.out.println(notifiDeudas);
		try {
			this.notifiDeudas.insertNotificacionDeudas(notifiDeudas);
		} catch (Exception e) {
			System.out.println("No se inserto");
			
		}
		System.out.println("se inserto");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateNotificacionDeudas(@RequestParam String codigo_alumno) {
		System.out.println("Se actualizara las notificaciones de deudas del ->");
		System.out.println(codigo_alumno);
		
		try {
			this.notifiDeudas.updateNotificacionDeudas(codigo_alumno);
		} catch (Exception e) {
			System.out.println("Hubo un error");
		}
		
	}
	
	
	
	

}
