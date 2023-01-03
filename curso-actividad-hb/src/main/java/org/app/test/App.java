package org.app.test;

import java.util.List;

import org.app.test.data.TestImpl;
import org.app.test.model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {

	SessionFactory factory;
	TestImpl test;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		App app = new App();
		app.init();
		app.saveEmployees();
		app.getAllEmployees();
		app.getEmployee();
		app.getEmployeeByCompanyName();
		app.deleteEmployee();
		app.getAllEmployees();
	}

	public void init() {
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		test = new TestImpl();
	}

	public void saveEmployees() {
		System.out.println("saving employees");
		
		Employee emp1 = new Employee();
		emp1.setCompany("Company 1");
		emp1.setFirstName("employee");
		emp1.setLastName("one");
		
		try {
			test.save(factory, emp1);
		} catch (Exception e) {
			System.out.println("Error al persistir objeto: " + e.getMessage());
		}
		
		Employee emp2 = new Employee();
		emp2.setCompany("Company 1");
		emp2.setFirstName("employee");
		emp2.setLastName("two");
		
		try {
			test.save(factory, emp2);
		} catch (Exception e) {
			System.out.println("Error al persistir objeto: " + e.getMessage());
		}
		
		Employee emp3 = new Employee();
		emp3.setCompany("Company 2");
		emp3.setFirstName("employee");
		emp3.setLastName("three");
		
		try {
			test.save(factory, emp3);
		} catch (Exception e) {
			System.out.println("Error al persistir objeto: " + e.getMessage());
		}
	}
	
	public void getAllEmployees() {
		System.out.println("get all employees");
		
		String queryString = "from Employee";
		
		List<Employee> employees = test.getAll(factory, queryString);
		if(employees != null && !employees.isEmpty()) {
			for(Employee obj : employees) {
				System.out.println(obj);
			}
		}
		else {
			System.out.println("no hay registros");
		}
	}
	
	public void getEmployee() {
		System.out.println("get employee by id");
		
		try {
			Employee emp = (Employee) test.get(factory, Employee.class, 1l);
			System.out.println(emp);
		} catch (Exception e) {
			System.out.println("Error al obtener employee: " + e.getMessage());
		}
	}
	
	public void getEmployeeByCompanyName() {
		System.out.println("get employee(s) by company name");
		
		try {
			List<Employee> employees = test.getByCompanyName(factory, "Company 2");
			
			if(employees != null && !employees.isEmpty()) {
				for(Employee obj : employees) {
					System.out.println(obj);
				}
			}
			else {
				System.out.println("no hay registros");
			}
			
		} catch (Exception e) {
			System.out.println("Error al consultar empleados: " + e.getMessage());
		}
	}
	
	public void deleteEmployee() {
		System.out.println("delete employee by id");
		
		try {
			test.delete(factory, 3l);
		} catch (Exception e) {
			System.out.println("Error al elmiminar: " + e.getMessage());
		}
	}
}
