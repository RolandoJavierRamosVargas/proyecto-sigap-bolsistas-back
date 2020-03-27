package edu.moduloalumno.service;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import edu.moduloalumno.entity.CuentasPorCobrar;
import edu.moduloalumno.entity.CuentasPorCobrar2;
import edu.moduloalumno.entity.DeudoresPosgradoMasInfo;
import edu.moduloalumno.entity.Recaudaciones;

public interface IRecaudacionesService {
	
	List<Recaudaciones> getAllRecaudaciones();

	List<Recaudaciones> getRecaudacionesByStartDateBetween(Date fechaInicial,Date fechaFinal);

	List<Recaudaciones> getRecaudacionesByNomApeStartDateBetween(String nomApe,Date fechaInicial,Date fechaFinal);

	List<Recaudaciones> getRecaudacionesByNomApe(String nomApe);
	
	List<Recaudaciones> getRecaudacionesByNomApeConcepto(String concepto, String nomApe);
	
	List<Recaudaciones> getRecaudacionesByNomApeRecibo( String recibo, String nomApe);
	
	List<Recaudaciones> getRecaudacionReci(String recibo);
	
	List<Recaudaciones> getRecaudacionesByPosgrado();

	List<Recaudaciones> getRecaudacionesByNombresApellidosStartDateBetween(String nombres,String apellidos,Date fechaInicial, Date fechaFinal);

	List<Recaudaciones> getRecaudacionesByNombresApellidos(String nombres, String apellidos);
	
	List<Recaudaciones> getRecaudacionesByNombresApellidosConcepto(String concepto, String nombres, String apellidos);
	
	List<Recaudaciones> getRecaudacionesByNombresApellidosRecibo( String recibo, String nombres, String apellidos);
	
	Recaudaciones getRecaudacionesById(int idRecaudaciones);

	void addRecaudaciones(Recaudaciones recaudaciones);

	int updateRecaudaciones(Recaudaciones recaudaciones);	

	void updateRecaudaciones(int idRec, String codAlum, Integer idProg);	
	
	int updateRecaudaciones(List<Recaudaciones> reacaudacionesList);

	void deleteRecaudaciones(int idRecaudaciones);
	
	//agregado por miguel
	List<Recaudaciones> getRecaudacionesPendiengesEntreFechas(Date fechaInicial, Date fechaFinal);
	List<Recaudaciones> getObservacionesEntreFechas(Date fechaInicial, Date fechaFinal);
	List<Recaudaciones> getRecaudacionesPorNombre(String nombresApellido);
	
	
	//Agregado por Rolando
	
	List<CuentasPorCobrar> getCuentasPorCobrar(String fechaInicial,String fechaFinal);
	
	List<DeudoresPosgradoMasInfo> getCuentasPorCobrar2(String fechaInicial,String fechaFinal);
	
	ByteArrayInputStream exportAllData(String fechaInicial,String fechaFinal) throws Exception;
	ByteArrayInputStream exportAllDataMasInfo(String fechaInicio,String fechaFin) throws Exception;
	
}