package edu.moduloalumno.dao;

import edu.moduloalumno.entity.NotificacionDeudas;

public interface INotificacionDeudasDao {
	void insertNotificacionDeudas(NotificacionDeudas notifiDeudas);
	void updateNotificacionDeudas(String codigo_alumno);
}
