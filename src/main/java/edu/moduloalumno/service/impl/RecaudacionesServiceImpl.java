package edu.moduloalumno.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.moduloalumno.dao.IRecaudacionesDAO;
import edu.moduloalumno.entity.CuentasPorCobrar;
import edu.moduloalumno.entity.CuentasPorCobrar2;
import edu.moduloalumno.entity.Recaudaciones;
import edu.moduloalumno.service.IRecaudacionesService;

@Service
public class RecaudacionesServiceImpl implements IRecaudacionesService {
	@Autowired
	private IRecaudacionesDAO recaudacionesDAO;
	
	@Override
	public List<Recaudaciones> getAllRecaudaciones() {
		return recaudacionesDAO.getAllRecaudaciones();
	}

	@Override
	public Recaudaciones getRecaudacionesById(int idRecaudaciones) {

		Recaudaciones recaudaciones = recaudacionesDAO.getRecaudacionesById(idRecaudaciones);
		
		return recaudaciones;
	}

	
	@Override
	public List<Recaudaciones> getRecaudacionesByStartDateBetween(Date fechaInicial, Date fechaFinal) {

		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionesByStartDateBetween(fechaInicial,
				fechaFinal);
		return recaudacionesList;
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNomApeStartDateBetween(String nomApe, Date fechaInicial,
			Date fechaFinal) {

		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionesByNomApeStartDateBetween(nomApe,
				fechaInicial, fechaFinal);
		
		return recaudacionesList;
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNomApe(String nomApe) {

		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionesByNomApe(nomApe);
		return recaudacionesList;
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNomApeConcepto(String concepto, String nomApe) {

		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionesByNomApeConcepto(concepto, nomApe);
		
		return recaudacionesList;
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNomApeRecibo(String recibo, String nomApe) {

		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionesByNomApeRecibo(recibo, nomApe);
		return recaudacionesList;

	}

	@Override
	public List<Recaudaciones> getRecaudacionesByPosgrado() {
		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionesByPosgrado();
		
		return recaudacionesList;
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNombresApellidosStartDateBetween(String nombres, String apellidos,
			Date fechaInicial, Date fechaFinal) {

		List<Recaudaciones> recaudacionesList = recaudacionesDAO
				.getRecaudacionesByNombresApellidosStartDateBetween(nombres, apellidos, fechaInicial, fechaFinal);
		
		return recaudacionesList;
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNombresApellidos(String nombres, String apellidos) {

		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionesByNombresApellidos(nombres, apellidos);
		
		return recaudacionesList;
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNombresApellidosConcepto(String concepto, String nombres,
			String apellidos) {

		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionesByNombresApellidosConcepto(concepto,
				nombres, apellidos);
		
		return recaudacionesList;
	}

	@Override
	public List<Recaudaciones> getRecaudacionesByNombresApellidosRecibo(String recibo, String nombres,
			String apellidos) {

		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionesByNombresApellidosRecibo(recibo,
				nombres, apellidos);
		return recaudacionesList;
	}

	@Override
	public synchronized void addRecaudaciones(Recaudaciones recaudaciones) {
		recaudacionesDAO.addRecaudaciones(recaudaciones);

	}

	@Override
	public int updateRecaudaciones(Recaudaciones recaudaciones) {
		return recaudacionesDAO.updateRecaudaciones(recaudaciones);
	}

	@Override
	public int updateRecaudaciones(List<Recaudaciones> reacaudacionesList) {
		int update = 0;
		for (Recaudaciones recaudaciones : reacaudacionesList) {
			update+=recaudacionesDAO.updateRecaudaciones(recaudaciones);
		}
		return update;
	}

	@Override
	public void updateRecaudaciones(int idRec, String codAlum, Integer idProg) {
		recaudacionesDAO.updateRecaudaciones(idRec,codAlum,idProg);
	}

	@Override
	public void deleteRecaudaciones(int idRecaudaciones) {
		recaudacionesDAO.deleteRecaudaciones(idRecaudaciones);
	}

	@Override
	public List<Recaudaciones> getRecaudacionReci(String recibo) {
		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionReci(recibo);
		
		return recaudacionesList;
	}
	
	
	//agregado por miguel
	@Override
	public List<Recaudaciones> getRecaudacionesPendiengesEntreFechas(Date fechaInicial, Date fechaFinal){
		System.out.println("iNGRESO AL SERVICE");
		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionesPendiengesEntreFechas(fechaInicial,
				fechaFinal);
		return recaudacionesList;
	}
	
	@Override
	public List<Recaudaciones> getRecaudacionesPorNombre(String nombresApellido){
		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getRecaudacionesPorNombre(nombresApellido);
		return recaudacionesList;
	}

	@Override
	public List<Recaudaciones> getObservacionesEntreFechas(Date fechaInicial, Date fechaFinal){
		List<Recaudaciones> recaudacionesList = recaudacionesDAO.getObservacionesEntreFechas(fechaInicial,
				fechaFinal);
		return recaudacionesList;
	}

	@Override
	public List<CuentasPorCobrar> getCuentasPorCobrar(String fechaInicial, String fechaFinal) {
		System.out.println("Entro a recaudacionesService");
		List<CuentasPorCobrar> cuentasPorCobrarList=recaudacionesDAO.getCuentasPorCobrar(fechaInicial,fechaFinal);
		return cuentasPorCobrarList;
	}
	
	@Override
	public List<CuentasPorCobrar2> getCuentasPorCobrar2(String fechaInicial, String fechaFinal) {
		System.out.println("Entro a recaudacionesService2");
		List<CuentasPorCobrar2> cuentasPorCobrarList=recaudacionesDAO.getCuentasPorCobrar2(fechaInicial,fechaFinal);
		return cuentasPorCobrarList;
	}

	@Override
	public ByteArrayInputStream exportAllData(String fechaInicio,String fechaFin) throws Exception {
		String[] columns = { "cod_alumno", "ape_paterno", "ape_materno", "nombres del alumno", "sigla_programa","cod_perm","max_anio_estudio","beneficio_otorgado","autorizacion","moneda","n_prioridad","concepto","descripcion_min", "importe_xpagar","importe_pagado","deuda","estado"};

		Workbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();

		Sheet sheet = workbook.createSheet("Cuentas Por Cobrar");
		Row row = sheet.createRow(0);

		for (int i = 0; i < columns.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columns[i]);
		}

		List<CuentasPorCobrar> cuentasPorCobrar = this.getCuentasPorCobrar(fechaInicio, fechaFin);
		int initRow = 1;
		for (CuentasPorCobrar cuenta : cuentasPorCobrar) {
			row = sheet.createRow(initRow);
			row.createCell(0).setCellValue(cuenta.getCod_alumno());
			row.createCell(1).setCellValue(cuenta.getApe_paterno());
			row.createCell(2).setCellValue(cuenta.getApe_materno());
			row.createCell(3).setCellValue(cuenta.getNom_alumno());
			row.createCell(4).setCellValue(cuenta.getSigla_programa());
			row.createCell(5).setCellValue(cuenta.getCod_perm());
			row.createCell(6).setCellValue(cuenta.getMax_anio_estudio());
			row.createCell(7).setCellValue(cuenta.getBeneficio_otorgado());
			row.createCell(8).setCellValue(cuenta.getAutorizacion());
			row.createCell(9).setCellValue(cuenta.getMoneda());
			row.createCell(10).setCellValue(cuenta.getN_prioridad());
			row.createCell(11).setCellValue(cuenta.getConcepto());
			row.createCell(12).setCellValue(cuenta.getDescripcion_min());
			row.createCell(13).setCellValue(cuenta.getImporte_xpagar());
			row.createCell(14).setCellValue(cuenta.getImporte_pagado());
			row.createCell(15).setCellValue(cuenta.getDeuda());
			row.createCell(16).setCellValue(cuenta.getEstado());

			initRow++;
		}

		workbook.write(stream);
		workbook.close();
		return new ByteArrayInputStream(stream.toByteArray());
	}
}

