package com.apiemployes.apiemployes.repository;

import com.apiemployes.apiemployes.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //défini la classe en tant que bean
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
