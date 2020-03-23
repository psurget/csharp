package ca.qc.cgodin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnnManager {
	String connectionString = "jdbc:mysql://";
	String login = "student";
	String pwd = "cgodin2018";
	Connection con = null;
	
	public AnnManager() {
		connectionString += "localhost:3306/rent4all";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(connectionString, login, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public List<Annonce> getAllAnnonces_list() {
		List<Annonce> annList = null;
		// 2 - déclarer un statement
		Statement stmt=null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3 - executer une requete Select
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * FROM Annonce");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 - lecture du resultat obtenu
		try {
			while (res.next()) {
				if (annList == null) {
					annList = new ArrayList<Annonce>();
				}
				Annonce a = new Annonce();
				a.setCategory(res.getString("Category"));
				a.setAmount(res.getDouble("Amount"));
				a.setDescription(res.getString("Description"));
				a.setCreationTS(res.getTimestamp("CreationTS"));
				a.setModifTS( res.getTimestamp("ModificationTS") );				
				annList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return annList;
	}

	public List<Annonce> getAnnoncesByUser_list(int userId) {
		List<Annonce> annList = null;
		// 2 - déclarer un statement
		Statement stmt=null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3 - executer une requete Select
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * FROM Annonce Where UserID=" + userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 - lecture du resultat obtenu
		try {
			while (res.next()) {
				if (annList == null) {
					annList = new ArrayList<Annonce>();
				}
				Annonce a = new Annonce();
				a.setCategory(res.getString("Category"));
				a.setAmount(res.getDouble("Amount"));
				a.setDescription(res.getString("Description"));
				a.setCreationTS(res.getTimestamp("CreationTS"));
				a.setModifTS( res.getTimestamp("ModificationTS") );				
				annList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return annList;
	}
	
	public void newAnnonce(Annonce a) {
		// 2 - déclarer un statement
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3 - executer une requete
		try {
			String req = "INSERT INTO annonce (userID, titre, description, amount, category) values ("+
						
						a.getUserID() +
						", " +
						sQuotes(a.getTitre()) + 
						 "," +
						 sQuotes(a.getDescription()) +
						 "," +
						 a.getAmount() + ", " +
						 
						 sQuotes(a.getCategory()) +
				")";
			stmt.executeUpdate(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String sQuotes(String txt) {
		return "'" + txt + "'";
	}
	
	
}