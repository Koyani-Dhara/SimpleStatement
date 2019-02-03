package simplestatement;

import java.util.List;

public interface EmployeeDAO {
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/collegemgt";
	final String DBUSER ="root";
	final String DBPASSWORD ="";
	
	public Boolean createEmployee(Employee employee);
	public Employee getEmployee(String empId);
	public Boolean deleteEmployee(String empId);
	public Boolean updateBasic(Employee employee);
	public List<Employee>getAllEmployee();

}
