package edu.moduloalumno.dao;

import java.util.List;

import edu.moduloalumno.entity.NotificacionCorrelativo;

public interface INotificacionCorrelativoDao {
	List<NotificacionCorrelativo> getNotificacionCorrelativos();
	void actualizarNotifiCorrelativo(NotificacionCorrelativo notifoCorre);
}
