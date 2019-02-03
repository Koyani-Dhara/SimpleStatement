package simplestatement;

import java.sql.SQLException;


public class Demo1 {



	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Employee employee=new Employee();
		
		employee.setEmpId("160010116022");
		employee.setFirstName("Dhara");
		employee.setLastName("Koyani");
		employee.setBasic(25000);
		
		EmployeDAOImpl employeDAOImpl=new EmployeDAOImpl();
		
		employeDAOImpl.createEmployee(employee);
		System.out.println(employeDAOImpl.getEmployee("160010116022"));
		employeDAOImpl.deleteEmployee("160010116022");
		
		Employee demployee = new Employee();
		demployee.setEmpId("160010116022");
		demployee.setFirstName("Foram");
		demployee.setLastName("Gajera");
		demployee.setBasic(35000);
		employeDAOImpl.updateBasic(demployee);
		
		System.out.println(employeDAOImpl.getAllEmployee());
		
	}

}
