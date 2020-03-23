package ca.qc.cgodin.model;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private String department;


/*============== CONSTRUCTORS ===========================*/
	public Employee() {
		super();
		this.id = 0;
		this.name = null;
		this.salary = 0.00;
		this.department = null;
	}
	
	public Employee(int id, String name, double salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
/*============== GETTERS & SETTERS =================*/
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}

}