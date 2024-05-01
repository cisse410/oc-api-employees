package sn.uidt.cisse410.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sn.uidt.cisse410.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
