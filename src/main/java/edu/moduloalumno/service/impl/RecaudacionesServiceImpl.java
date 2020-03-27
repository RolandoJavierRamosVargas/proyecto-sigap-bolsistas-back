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
import edu.moduloalumno.entity.DeudoresPosgradoMasInfo;
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
	public List<DeudoresPosgradoMasInfo> getCuentasPorCobrar2(String fechaInicial, String fechaFinal) {
		System.out.println("Entro a recaudacionesService2");
		List<DeudoresPosgradoMasInfo> cuentasPorCobrarList=recaudacionesDAO.getCuentasPorCobrar2(fechaInicial,fechaFinal);
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
	
	
	@Override
	public ByteArrayInputStream exportAllDataMasInfo(String fechaInicio,String fechaFin) throws Exception {
		
		String[] columns = { "cod_alumno", "id_programa","ape_paterno", "ape_materno", "nombres del alumno","n_prioridad", "sigla_programa","año de ingreso","cod_perm","max_anio_estudio","beneficio_otorgado","autorizacion","moneda","prioridad","id_concepto","concepto","descripcion_min", "importe_xpagar","importe_pagado","deuda","notificacion_deuda","deuda_estado","estado","coe_alumno","coe_alu_personal","tel_alu_movil","tel_alumno","des_doc_identidad","did_alumno","dir_tip_via","dir_tip_via_nom","dir_num_puerta","dir_num_piso","dir_num_dpto","dir_num_mz","dir_num_lote","dir_num_km","dir_tip_loc","dir_tip_loc_nom","departamento","provincia","distrito"};
		Workbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();

		Sheet sheet = workbook.createSheet("Deudas con mas informacion personal");
		Row row = sheet.createRow(0);

		for (int i = 0; i < columns.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columns[i]);
		}

		List<DeudoresPosgradoMasInfo> deudoresPosgrado = this.getCuentasPorCobrar2(fechaInicio, fechaFin);
		int initRow = 1;
		for (DeudoresPosgradoMasInfo cuenta : deudoresPosgrado) {
			row = sheet.createRow(initRow);
			row.createCell(0).setCellValue(cuenta.getCod_alumno());
			row.createCell(1).setCellValue(cuenta.getId_programa());
			row.createCell(2).setCellValue(cuenta.getApe_paterno());
			row.createCell(3).setCellValue(cuenta.getApe_materno());
			row.createCell(4).setCellValue(cuenta.getNom_alumno());
			row.createCell(5).setCellValue(cuenta.getN_prioridad());
			row.createCell(6).setCellValue(cuenta.getSigla_programa());
			row.createCell(7).setCellValue(cuenta.getAnio_ingreso());
			row.createCell(8).setCellValue(cuenta.getCod_perm());
			row.createCell(9).setCellValue(cuenta.getMax_anio_estudio());
			row.createCell(10).setCellValue(cuenta.getBeneficio_otorgado());
			row.createCell(11).setCellValue(cuenta.getAutorizacion());
			row.createCell(12).setCellValue(cuenta.getMoneda());
			row.createCell(13).setCellValue(cuenta.getN_prioridad2());
			row.createCell(14).setCellValue(cuenta.getId_concepto());
			row.createCell(15).setCellValue(cuenta.getConcepto());
			row.createCell(16).setCellValue(cuenta.getDescripcion_min());
			row.createCell(17).setCellValue(cuenta.getImporte_xpagar());
			row.createCell(18).setCellValue(cuenta.getImporte_pagado());
			row.createCell(19).setCellValue(cuenta.getDeuda());
			row.createCell(20).setCellValue(cuenta.getNotificacion_deuda());
			row.createCell(21).setCellValue(cuenta.getDeuda_estado());
			row.createCell(22).setCellValue(cuenta.getEstado());
			row.createCell(23).setCellValue(cuenta.getCoe_alumno());
			row.createCell(24).setCellValue(cuenta.getCoe_alu_personal());
			row.createCell(25).setCellValue(cuenta.getTel_alu_movil());
			row.createCell(26).setCellValue(cuenta.getTel_alumno());
			row.createCell(27).setCellValue(cuenta.getDes_doc_identidad());
			row.createCell(28).setCellValue(cuenta.getDid_alumno());
			row.createCell(29).setCellValue(cuenta.getDir_tip_via());
			row.createCell(30).setCellValue(cuenta.getDir_tip_via_nom());
			row.createCell(31).setCellValue(cuenta.getDir_num_puerta());
			row.createCell(32).setCellValue(cuenta.getDir_num_piso());
			row.createCell(33).setCellValue(cuenta.getDir_num_dpto());
			row.createCell(34).setCellValue(cuenta.getDir_num_mz());
			row.createCell(35).setCellValue(cuenta.getDir_num_lote());
			row.createCell(36).setCellValue(cuenta.getDir_num_km());
			row.createCell(37).setCellValue(cuenta.getDir_tip_loc());
			row.createCell(38).setCellValue(cuenta.getDir_tip_loc_nom());
			row.createCell(39).setCellValue(cuenta.getDepartamento());
			row.createCell(40).setCellValue(cuenta.getProvincia());
			row.createCell(41).setCellValue(cuenta.getDistrito());
		
			
			

			initRow++;
		}

		workbook.write(stream);
		workbook.close();
		return new ByteArrayInputStream(stream.toByteArray());
	}
}

