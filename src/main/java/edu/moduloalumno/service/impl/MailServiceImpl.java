package edu.moduloalumno.service.impl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.time.LocalTime;

import static j2html.TagCreator.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.moduloalumno.entity.CuentasPorCobrar2;
import edu.moduloalumno.entity.DeudoresPosgradoMasInfo;
import edu.moduloalumno.entity.NotificacionCorrelativo;
import edu.moduloalumno.entity.NotificacionDeudas;
import edu.moduloalumno.entity.SendMail;
import edu.moduloalumno.service.IMailService;
import edu.moduloalumno.service.INotificacionCorrelativoService;
import edu.moduloalumno.service.INotificacionDeudasService;

@Service
public class MailServiceImpl implements IMailService {

	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private INotificacionCorrelativoService notifiCorre;
	
	
	@Autowired
	private INotificacionDeudasService notifiDeudas;
	
	@Override
	public void sendMail(SendMail email) throws MessagingException {
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mail = new MimeMessageHelper(mimeMessage,true);
		Gson gson = new Gson();
		
		Type listType = new TypeToken<ArrayList<DeudoresPosgradoMasInfo>>(){}.getType();
		ArrayList<DeudoresPosgradoMasInfo> cuentas = gson.fromJson(email.getDatos(), listType);
		
		List<NotificacionCorrelativo> notificacion=null;
		NotificacionCorrelativo notificacionCorrelativo=null;
		
		notificacion=notifiCorre.getNotificacionCorrelativos();
		notificacionCorrelativo=notificacion.get(notificacion.size()-1);
		
		
		int notificacion_actual=notificacionCorrelativo.getN_correlativo();
		String anio=notificacionCorrelativo.getAnio();
		
		
		DeudoresPosgradoMasInfo cuenta;
		String nuevoSubject;
		String banco_codigoPago="<h3><b> Banco Pichincha, Cuenta UNMSM </b>: <span style=\"color:#0000FF\"> 270016684 </span> </h3>" ;
		
		Iterator iter=cuentas.iterator();
			while(iter.hasNext()) {
				cuenta=(DeudoresPosgradoMasInfo)iter.next();
				notificacion_actual++;
				nuevoSubject=(notificacion_actual<100)? email.getSubject()+" 0"+Integer.toString(notificacion_actual)+"-"+anio : email.getSubject()+" "+Integer.toString(notificacion_actual)+"-"+anio;
				
				String primerParrafo="<b> Sr(a) "+cuenta.getApe_paterno()+"</b> <br></br> <br></br>";
				String cuerpo=email.getBody()+" <br></br> <br> </br>";
				
				
				String htmlMostrar=this.construirTabla(cuenta);
				String footer=email.getFooter();
				String cuerpoAEnviar=primerParrafo+cuerpo+banco_codigoPago+htmlMostrar+footer;
				
				
				System.out.println(new Date());
				this.updateUltimos(cuenta.getCod_alumno());
				
				System.out.println("el email es "+email.getFrom());
				
//				if(cuenta.getCoe_alumno()!="") {
//					mail.setFrom(email.getFrom());
//			        mail.setTo(cuenta.getCoe_alumno());
//			        mail.setSubject(nuevoSubject);
//			        mail.setText(cuerpoAEnviar,true);
//			        
//			        javaMailSender.send(mimeMessage);
//			        
//				}
//				if(cuenta.getCoe_alu_personal()!="") {
//			        mail.setFrom(email.getFrom());
//			        mail.setTo(cuenta.getCoe_alu_personal());
//			        mail.setSubject(nuevoSubject);
//			        mail.setText(cuerpoAEnviar,true);
//			        javaMailSender.send(mimeMessage);
//				}
				String[] correos= {cuenta.getCoe_alumno(),cuenta.getCoe_alu_personal(),"upg.fisi@unmsm.edu.pe"};
			     
				//envio al correo de upg fisi
					mail.setFrom(email.getFrom());
			        mail.setTo(correos);
			        mail.setSubject(nuevoSubject);
			        mail.setText(cuerpoAEnviar,true);
			        javaMailSender.send(mimeMessage);
			        
			        //Insertar la fila en la tabla 
			        this.insertarNotificacionDeudas(cuenta, notificacion_actual, Integer.parseInt(anio) );
			}
			
			//actualizar numero correlativo
			NotificacionCorrelativo notificacionActualizacion=new NotificacionCorrelativo(anio,notificacion_actual," ");
			notifiCorre.actualizarNotifiCorrelativo(notificacionActualizacion);
		
	}
	
	public String construirTabla(DeudoresPosgradoMasInfo cuenta) {
		/****************/
		ArrayList<String> array1=new ArrayList<String>();
		String[] campos = {"cod_alumno"	,"ape_paterno"	,"ape_materno"	,"nombres del alumno",	"sigla_programa",	"moneda"	,"concepto"	,"descripcion_min"	,"importe_xpagar"	,"importe_pagado"	,"deuda"};
		
		for (String string : campos) {
			array1.add(string);
		}
		
		ArrayList<String> array2=new ArrayList<String>();
		
		String[] respuestas = { cuenta.getCod_alumno(),cuenta.getApe_paterno(),cuenta.getApe_materno(),cuenta.getNom_alumno() ,cuenta.getSigla_programa(),cuenta.getMoneda(),cuenta.getConcepto(),cuenta.getDescripcion_min(),""+cuenta.getImporte_xpagar(),""+cuenta.getImporte_pagado(),""+cuenta.getDeuda()};
		
		for (String string2 : respuestas) {
			array2.add(string2);
		}
		/****************/
		String htmlMostrar="<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <title>Document</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" +
				"   <table style=\"border: 1px solid #000;\"> "+
				"        <thead>\r\n" + 
				"            <tr>\r\n" +	
				"                <th style=\"border: 1px solid #000;\">"+campos[0]+"</th>\r\n" + 
				"                <th style=\"border: 1px solid #000;\">"+campos[1]+"</th>\r\n" + 
				"                <th style=\"border: 1px solid #000;\">"+campos[2]+"</th>\r\n" + 
				"                <th style=\"border: 1px solid #000;\">"+campos[3]+"</th>\r\n" + 
				"                <th style=\"border: 1px solid #000;\">"+campos[4]+"</th>\r\n" + 
				"                <th style=\"border: 1px solid #000;\">"+campos[5]+"</th>\r\n" +
				"                <th style=\"border: 1px solid #000;\">"+campos[6]+"</th>\r\n" + 
				"                <th style=\"border: 1px solid #000;\">"+campos[7]+"</th>\r\n" + 
				"                <th style=\"border: 1px solid #000; \" >"+campos[8]+"</th>\r\n" +
				"                <th style=\"border: 1px solid #000;\">"+campos[9]+"</th>\r\n" + 
				"                <th style=\"border: 1px solid #000;\">"+campos[10]+"</th>\r\n" + 
				"            </tr>\r\n" + 
				"            </thead>\r\n" + 
				"            <tbody>\r\n" + 
				"                <tr>\r\n" + 
				"                    <td style=\"border: 1px solid #000;\">"+respuestas[0]+"</td>\r\n" + 
				"                    <td style=\"border: 1px solid #000;\">"+respuestas[1]+"</td>\r\n" +
				"                    <td style=\"border: 1px solid #000;\">"+respuestas[2]+"</td>\r\n" + 
				"                    <td style=\"border: 1px solid #000;\">"+respuestas[3]+"</td>\r\n" +
				"                    <td style=\"border: 1px solid #000;\">"+respuestas[4]+"</td>\r\n" + 
				"                    <td style=\"border: 1px solid #000;\">"+respuestas[5]+"</td>\r\n" +
				"                    <td style=\"border: 1px solid #000;background-color:#e5be01;\">"+respuestas[6]+"</td>\r\n" + 
				"                    <td style=\"border: 1px solid #000;\">"+respuestas[7]+"</td>\r\n" +
				"                    <td style=\"border: 1px solid #000;  \">"+respuestas[8]+"</td>\r\n" + 
				"                    <td style=\"border: 1px solid #000;\">"+respuestas[9]+"</td>\r\n" +
				"                    <td style=\"border: 1px solid #000;background-color:#e5be01;\">"+respuestas[10]+"</td>\r\n" +
				"                </tr>\r\n" + 
				"            </tbody>\r\n" + 
				"    </table>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
		System.out.println("el html es "+htmlMostrar);
		return htmlMostrar;
	}

	public void insertarNotificacionDeudas(DeudoresPosgradoMasInfo cuenta,int numero_notificacion,int anio_notificacion) {
	
		NotificacionDeudas notificacionDeudas=new NotificacionDeudas();
		notificacionDeudas.setCod_alumno(cuenta.getCod_alumno());
		notificacionDeudas.setId_programa(cuenta.getId_programa());
		notificacionDeudas.setN_notificacion(numero_notificacion); // insertaremos el numero de notificacion
		notificacionDeudas.setAnio_notificacion(anio_notificacion); //pasaremos el anio de notificacion
		notificacionDeudas.setFecha_notificacion(new Date());
		notificacionDeudas.setId_moneda(cuenta.getId_moneda());
		notificacionDeudas.setId_concepto(cuenta.getId_concepto());
		notificacionDeudas.setImporte_deuda(cuenta.getImporte_xpagar());
		notificacionDeudas.setL_ultimo("S");
		
		notifiDeudas.insertNotificacionDeudas(notificacionDeudas);
			
	}
	
	
	public void updateUltimos(String codigo_alumno) {
		this.notifiDeudas.updateNotificacionDeudas(codigo_alumno);
	}
}
