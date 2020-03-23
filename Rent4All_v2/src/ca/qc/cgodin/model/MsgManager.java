package ca.qc.cgodin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MsgManager {
	String connectionString = "jdbc:mysql://";
	String login = "student";
	String pwd = "cgodin2018";
	Connection con = null;
	
	public MsgManager() {
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

	public List<Message> getMsgList() {
		List<Message> msgList = null;
		// 2 - déclarer un statement
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3 - executer une requete Select
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * FROM Message");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 4 - lecture du resultat obtenu
		try {
			while (res.next()) {
				if (msgList == null) {
					msgList = new ArrayList<Message>();
				}
				Message m = new Message();
				m.setUserId_from(res.getInt("UserId_from"));
				m.setSubject(res.getString("Subject"));
				m.setStatutMsg(res.getString("Statut"));
				m.setCreationTS( res.getTimestamp(4) );
				m.setModifTS( res.getTimestamp(5) );				
				msgList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msgList;
	}
	
	
	public void newMessage(Message m) {
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
			String req = "INSERT INTO message (UserID_from, AnnonceID, Subject, Message) values ("+
						m.getUserId_from() +
						", " +
						m.getAnnonceId() + 
						 "," +
						 sQuotes(m.getSubject()) +
						 ","+
						 sQuotes(m.getMessage()) +
						 ")";
			stmt.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String sQuotes(String txt) {
		return "'" + txt + "'";
	}
}