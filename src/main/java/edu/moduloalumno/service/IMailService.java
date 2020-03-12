package edu.moduloalumno.service;

import javax.mail.MessagingException;

import edu.moduloalumno.entity.SendMail;

public interface IMailService {
	void sendMail(SendMail mail) throws MessagingException;
}
