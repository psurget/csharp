package ca.qc.cgodin.model;

import java.sql.Timestamp;
import java.util.Calendar;

public class User {
	private int UserID;
    private String LastName;
    private String FirstName;
    private String Email;
    private String Phone;
    private Timestamp CreationTS;
    private Timestamp ModificationTS;
    private String Password;
    private String Status;

 // CONSTRUCTORS   
   
    public User(String lastName, String firstName, String email, String phone, String password) {

    	LastName = lastName;
    	FirstName = firstName;
    	Email = email;
    	Phone = phone;
    	CreationTS = getCurTS();
    	Password = password;
    	Status = "actif";
    }

    
    public User(String lastName, String email, String phone,  String password) {
    	LastName = lastName;
    	Email = email;
    	Phone = phone;
    	Password = password;
    	Status = "actif";
    }
    
    public User(String email, String phone,  String password) {
    	Email = email;
    	Phone = phone;
    	Password = password;
    	Status = "actif";
    }
    
    public User(String email, String password) {
    	Email = email;
    	Password = password;
    	Status = "actif";
    }
    
    public User() {
    	LastName = null;
    	FirstName = null;
    	Email = null;
    	Phone = null;
    	CreationTS = getCurTS();
    	Password = null;
    	Status = "actif";
    }

    public Timestamp getCurTS() {
    	Calendar calendar = Calendar.getInstance();
    	Timestamp ts = new Timestamp(calendar.getTime().getTime());
    	return ts;
    }
    
    
/*=========================== GETTERS & SETTERS ==============================*/   
    
	public int getUserID() {
		return UserID;
	}
	
	public void setUserID(int UserID) {
		this.UserID = UserID;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	public Timestamp getCreationTS() {
		return CreationTS;
	}
	public void setCreationTS(Timestamp CreationTS) {
		this.CreationTS = CreationTS;
	}
	public Timestamp getModificationTS() {
		return ModificationTS;
	}
	public void setModificationTS(Timestamp ModificationTS) {
		this.ModificationTS = ModificationTS;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String string) {
		Password = string;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
    
}
