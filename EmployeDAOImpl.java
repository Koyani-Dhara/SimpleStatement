package simplestatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeDAOImpl implements EmployeeDAO {


	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private String query;
	
	EmployeDAOImpl() throws ClassNotFoundException, SQLException{
		
		Class.forName(DRIVER);
		connection = DriverManager.getConnection(URL,DBUSER,DBPASSWORD);
		statement = connection.createStatement();
		
	}

	@Override
	public Boolean createEmployee(Employee employee) {
		
		query="insert into Employee_tbl values('"+employee.getEmpId()+"','"+employee.getFirstName()+"','"+employee.getLastName()+"',"+employee.getBasic()+")";
		
	try {
		statement.execute(query);
		System.out.println("Employee Created.");
	} catch (Exception e) {
		
		return false;
	}
	return true;
	
		
	}

	@Override
	public Employee getEmployee(String empId) {
		
		query ="select * from Employee_tbl where empId = '"+empId+"'";
		Employee employee=new Employee();
		try {
			resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				employee.setEmpId(resultSet.getString(1));
				employee.setFirstName(resultSet.getString(2));
				employee.setLastName(resultSet.getString(3));
				employee.setBasic(resultSet.getInt(4));
			}
			return employee;
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return new Employee();
	}

	@Override
	public Boolean deleteEmployee(String empId) {
		
		query="delete from Employee_tbl where empId='"+empId+"'";
		try {
			statement.execute(query);
			System.out.println("Deleted");
		} catch (SQLException e) {
			return false;
			
		}
		return true;
	}

	@Override
	public Boolean updateBasic(Employee employee) {
		
		query="update Employee_tbl set firstName='"+employee.getFirstName()+"',lastName='"+employee.getLastName()+"',basic="+employee.getBasic()+" where empId='"+employee.getEmpId()+"'";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Employee> getAllEmployee() {
		query ="select * from Employee_tbl";
		
		List<Employee> emplist=new ArrayList<Employee>();
		try {
			resultSet=statement.executeQuery(query);
			
			while(resultSet.next()) {
				
				Employee employee=new Employee();
				employee.setEmpId(resultSet.getString(1));
				employee.setFirstName(resultSet.getString(2));
				employee.setLastName(resultSet.getString(3));
				employee.setBasic(resultSet.getInt(4));
				emplist.add(employee);
			}
		} catch (SQLException e) {
			return null;
		}
		
		return emplist;
		
		
	
	}
}
