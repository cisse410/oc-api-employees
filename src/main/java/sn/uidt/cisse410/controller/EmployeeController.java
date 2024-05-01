package sn.uidt.cisse410.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sn.uidt.cisse410.model.Employee;
import sn.uidt.cisse410.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	/**
	 * Create - Ajouter un nouveau employee
	 * @param employee un objet de type Employee
	 * @return The employee object saved
	 */
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	
	/**
	 * Read - Afficher un employee 
	 * @param id l'id de l'employee a afficher
	 * @return Un Employee avec tout les champs
	 */
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") final Long id) {
		Optional<Employee> employee = employeeService.getEmployee(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Afficher l'ensemble des employees
	 * @return - Un objet Iterable des employees avec tous les champs 
	*/
	@GetMapping("/employee")
	public Iterable<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	/**
	 * Update - Modifier un employee existant
	 * @param id - l'id de l'employee a modifier
	 * @param employee - l'objet Employee a modifier
	 * @return
	 */
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
		Optional<Employee> e = employeeService.getEmployee(id);
		if(e.isPresent()) {
			Employee currentEmployee = e.get();
			
			String firstName = employee.getFirstName();
			if(firstName != null) {
				currentEmployee.setFirstName(firstName);
			}
			String lastName = employee.getLastName();
			if(lastName != null) {
				currentEmployee.setLastName(lastName);;
			}
			String mail = employee.getMail();
			if(mail != null) {
				currentEmployee.setMail(mail);
			}
			String password = employee.getPassword();
			if(password != null) {
				currentEmployee.setPassword(password);;
			}
			employeeService.saveEmployee(currentEmployee);
			return currentEmployee;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Supprimer un employee
	 * @param id - L'id de l'employee a supprimer
	 */
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable("id") final Long id) {
		employeeService.deleteEmployee(id);
	}
}
