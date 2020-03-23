
package ca.qc.cgodin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeeManager {
    	String connectionString = "jdbc:mysql://";
    	String login = "student";
    	String pwd = "cgodin2018";
    	Connection conn = null;
    	
    	public EmployeeManager() {
    		connectionString += "localhost:3306/employee";
    		try {
    			/*********************************************/
    			Class.forName("com.mysql.jdbc.Driver").newInstance();
    			/*********************************************/
    			conn = DriverManager.getConnection(connectionString, login, pwd);
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
    	
    	public List<Employee> getEmployee(){
    		List<Employee> employees_list = null;
    		
    		Statement stmt = null;
    		try {
    			stmt = conn.createStatement();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		ResultSet res = null;
    		try {
    			res = stmt.executeQuery("SELECT * FROM employee");
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		try {
    			while (res.next()) {
    				if (employees_list == null) {
    					employees_list = new ArrayList<Employee>();
    				}
    				Employee e = new Employee();
    				e.setDepartment(res.getString("department"));
    				e.setName(res.getString("name"));
    				e.setSalary(res.getDouble("salary"));

    				employees_list.add(e);
    			}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    		return employees_list;
    	}
    	
    	
    	public List<Employee> getEmployeeByDept(String dept){
    		List<Employee> employees_list = null; 		
    		Statement stmt = null;
    		try {
    			stmt = conn.createStatement();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		ResultSet res = null;
    		try {
    			res = stmt.executeQuery("SELECT * FROM employee Where department="+ sQuotes(dept));
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		try {
    			while (res.next()) {
    				if (employees_list == null) {
    					employees_list = new ArrayList<Employee>();
    				}
    				Employee e = new Employee();
    				e.setDepartment(res.getString("department"));
    				e.setName(res.getString("name"));
    				e.setSalary(res.getDouble("salary"));

    				employees_list.add(e);
    			}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    		return employees_list;
    	}
    	
    	public int addEmployee(String name, Double sal, String dept) {
    		Statement stmt = null;
    		try {
    			stmt = conn.createStatement();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}   		
    		String request = "INSERT INTO employee (name, salary, department) VALUES"+
    						"("+ sqlParam(name) + sal + "," + sqlParam(dept) + ")";   		
    		int affectedRows = 0;
    		try {
    			affectedRows =  stmt.executeUpdate(request);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return affectedRows;
    	}
    	
    	public int deleteProduct(int id) {
    		Statement stmt = null;
    		try {
    			stmt = conn.createStatement();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		String request = "DELETE FROM product  WHERE numProd = "+ id;
    		
    		int affectedRows = 0;
    		try {
    			affectedRows =  stmt.executeUpdate(request);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		return affectedRows;
    	}
    	
    	public int updateProduct(int id, String name, double price) {
    		Statement stmt = null;
    		try {
    			stmt = conn.createStatement();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		String request = "UPDATE product SET nameProd='"+name+"',  priceProd="
    						 + price + " WHERE numProd="+ id;
    		
    		int affectedRows = 0;
    		try {
    			affectedRows =  stmt.executeUpdate(request);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		return affectedRows;
    	}
    
    public void fermerConnection()throws SQLException{
        conn.close();
    }
    
    public String sQuotes(String text){
		return "'" + text + "'";
	}
    
    public String sqlParam(String text){
		return "'" + text + "',";
	}
    
}
