package com.apiemployes.apiemployes.service;

import com.apiemployes.apiemployes.model.Employee;
import com.apiemployes.apiemployes.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data // génère automatiquement les gettes et setters puis le constructeur par défaut de la classe
@Service //défini la classe en tant que bean
public class EmployeeService {

    //injection une instance de EmployeeRepository
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(final Long id){
        return employeeRepository.findById(id);

    }

    public Iterable<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(final Long id){
       employeeRepository.deleteById(id);
    }

    public Employee saveEmployee (Employee employee){
        Employee saveEmployee = employeeRepository.save(employee);
        return  saveEmployee;
    }





}
