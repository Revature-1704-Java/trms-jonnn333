package daos;

import java.util.List;

import the_beans.Employee;

public interface EmployeeDAO_Interface {

	public List<Employee> getAllEmployees();
	public Employee getEmployee(Integer eid);
	
	public boolean isValidEmployee(String email, String password);
}
