package entities;

public class DepartmentEmployee extends Customer {


	private int EmployeeNum;
	private String role;
	private String authorization;
	
	
	
	
	public int getEmployeeNum() {
		return EmployeeNum;
	}
	public void setEmployeeNum(int employeeNum) {
		EmployeeNum = employeeNum;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	
	
	
}
