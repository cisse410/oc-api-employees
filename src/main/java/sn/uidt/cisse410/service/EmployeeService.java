package sn.uidt.cisse410.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import sn.uidt.cisse410.model.Employee;
import sn.uidt.cisse410.repository.EmployeeRepository;

@Data
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// Pour un employee par son id
	public Optional<Employee> getEmployee(final Long id) {
		return employeeRepository.findById(id);
	}
	
	// Pour recuperer la liste de toute les employees
	public Iterable<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	// Pour supprimer un employee
	public void deleteEmployee(final Long id) {
		employeeRepository.deleteById(id);
	}
	
	// Ajouter un employee
	public Employee saveEmployee(Employee employee) {
		Employee saveEmployee = employeeRepository.save(employee);
		
		return saveEmployee;
	}
	
}
