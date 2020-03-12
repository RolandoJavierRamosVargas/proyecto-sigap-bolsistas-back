package edu.moduloalumno.entity;

public class SendMail {
	
	private String from;
	private String to;
	private String subject;
	private String body;
	private String datos;
	private String footer;
	
	
	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
	public SendMail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDatos() {
		return datos;
	}
	public void setDatos(String datos) {
		this.datos = datos;
	}
	@Override
	public String toString() {
		return "SendMail [from=" + from + ", to=" + to + ", subject=" + subject + ", body=" + body + ", datos=" + datos
				+ ", footer=" + footer + "]";
	}
	
	

}
