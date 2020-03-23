package ca.qc.cgodin.model;

import java.sql.Timestamp;

public class Message {
	private int MessageId;
	private int AnnonceId;
	private String Subject;
	private String Message;
	private String StatutMsg;
	private Timestamp CreationTS;
	private Timestamp ModifTS;
	private int UserId_from;
	private int UserId_to;
	

/* ================ Constructors =====================*/
	
	public Message() {
		
	}
	
	public Message(int messageId, int annonceId, String subject, String message, String statutMsg, Timestamp creationTS,
			Timestamp modifTS, int userId_from, int userId_to) {
		MessageId = messageId;
		AnnonceId = annonceId;
		Subject = subject;
		Message = message;
		StatutMsg = "brouillon";
		CreationTS = creationTS;
		ModifTS = modifTS;
		UserId_from = userId_from;
		UserId_to = userId_to;
	}
	
	
	
/* =============== Getters & Setters ================ */	
	
	public int getMessageId() {
		return MessageId;
	}
	public void setMessageId(int messageId) {
		MessageId = messageId;
	}
	public int getAnnonceId() {
		return AnnonceId;
	}
	public void setAnnonceId(int annonceId) {
		AnnonceId = annonceId;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		
		Subject = subject;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getStatutMsg() {
		return StatutMsg;
	}
	public void setStatutMsg(String statutMsg) {
		StatutMsg = statutMsg;
	}
	public Timestamp getCreationTS() {
		return CreationTS;
	}
	public void setCreationTS(Timestamp creationTS) {
		CreationTS = creationTS;
	}
	public Timestamp getModifTS() {
		return ModifTS;
	}
	public void setModifTS(Timestamp modifTS) {
		ModifTS = modifTS;
	}
	public int getUserId_from() {
		return UserId_from;
	}
	public void setUserId_from(int userId_from) {
		UserId_from = userId_from;
	}
	public int getUserId_to() {
		return UserId_to;
	}
	public void setUserId_to(int userId_to) {
		UserId_to = userId_to;
	}
		
}
