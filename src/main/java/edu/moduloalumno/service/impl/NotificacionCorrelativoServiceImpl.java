package edu.moduloalumno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.INotificacionCorrelativoDao;
import edu.moduloalumno.entity.NotificacionCorrelativo;
import edu.moduloalumno.service.INotificacionCorrelativoService;

@Service
public class NotificacionCorrelativoServiceImpl implements INotificacionCorrelativoService {

	@Autowired
	private INotificacionCorrelativoDao notifiCorre;
	
	@Override
	public List<NotificacionCorrelativo> getNotificacionCorrelativos() {
		
		return notifiCorre.getNotificacionCorrelativos();
	}

	@Override
	public void actualizarNotifiCorrelativo(NotificacionCorrelativo notifoCorre) {
		notifiCorre.actualizarNotifiCorrelativo(notifoCorre);
		
	}

}
