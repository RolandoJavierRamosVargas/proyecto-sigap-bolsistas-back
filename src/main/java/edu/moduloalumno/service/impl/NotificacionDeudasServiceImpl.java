package edu.moduloalumno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.moduloalumno.dao.INotificacionDeudasDao;
import edu.moduloalumno.entity.NotificacionDeudas;
import edu.moduloalumno.service.INotificacionDeudasService;

@Service
public class NotificacionDeudasServiceImpl implements INotificacionDeudasService{

	@Autowired
	private INotificacionDeudasDao notifiDeudas;
	
	@Override
	public void insertNotificacionDeudas(NotificacionDeudas notifiDeudas) {
		this.notifiDeudas.insertNotificacionDeudas(notifiDeudas);
		
	}

	@Override
	public void updateNotificacionDeudas(String codigo_alumno) {
		this.notifiDeudas.updateNotificacionDeudas(codigo_alumno);
		
	}

}
