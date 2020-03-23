package ca.qc.cgodin.model;

import java.sql.Timestamp;
import java.util.*;


public class Annonce {
	private int AnnonceID;
	private int UserID;
	private String Titre;
	private String Description;
	private String Statut;
	private double Amount;
	private String Category;
	private Timestamp CreationTS;
	private Timestamp ModifTS;
	
	
/*=========== CONSTRUCTORS ================*/
	
	public Annonce(){ 
		this.AnnonceID=0;
		this.Amount=0;
		this.Category=null;
		this.Titre=null;
		this.Description=null;
		this.Statut=null;
		this.CreationTS = getCurTS();
	}
		
public Annonce(int userID, String titre, String description, double amount, String category) {
	UserID = userID;
	Titre = titre;
	Description = description;
	Statut = "actif";
	Amount = amount;
	Category = category;
	CreationTS = getCurTS();
	ModifTS	= null;
}

public Annonce(int userID, String titre, String description, double amount) {
	UserID = userID;
	Titre = titre;
	Description = description;
	Statut = "actif";
	Amount = amount;
	CreationTS = getCurTS();
	ModifTS	= null;
}

public Annonce(int userID, String titre, String description) {
	UserID = userID;
	Titre = titre;
	Description = description;
	Statut = "actif";
	CreationTS = getCurTS();
	ModifTS	= null;
}

public Annonce(int userID, String titre) {
	this.UserID = userID;
	this.Titre = titre;
	this.Statut = "actif";
	this.CreationTS = getCurTS();
	this.ModifTS = null;
}


//============ GETTERS & SETTERS ================	
	public int getAnnonceID() {
		return AnnonceID;
	}
	public void setAnnonceID(int annonceID) {
		AnnonceID = annonceID;
	}
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	
	public String getStatut() {
		return Statut;
	}
	public void setStatut(String statut) {
		Statut = statut;
	}
	
	public Timestamp getCreationTS() {
		return CreationTS;
	}
	public void setCreationTS(Timestamp creationTS) {
		CreationTS =  getCurTS();
	}
	
	public Timestamp getModifTS() {
		return ModifTS;
	}
	public void setModifTS(Timestamp modifTS) {
		ModifTS = getCurTS();
	}
	
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		this.Amount = amount;
	}
	
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public java.sql.Timestamp getCurTS(){

		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp curTS = new java.sql.Timestamp(now.getTime());
		
		return curTS;
	}

	
}
