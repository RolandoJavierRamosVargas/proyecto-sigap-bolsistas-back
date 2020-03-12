package edu.moduloalumno.service;

import java.util.List;

import edu.moduloalumno.entity.NotificacionCorrelativo;

public interface INotificacionCorrelativoService {
	 List<NotificacionCorrelativo> getNotificacionCorrelativos();
	 void actualizarNotifiCorrelativo(NotificacionCorrelativo notifoCorre);
}
