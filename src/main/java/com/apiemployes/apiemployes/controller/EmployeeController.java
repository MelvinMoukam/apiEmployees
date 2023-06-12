package com.apiemployes.apiemployes.controller;

import com.apiemployes.apiemployes.model.Employee;
import com.apiemployes.apiemployes.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//défini la classe en tant que bean & indique à spring d'insérer le retour de la méthode au format JSON
@RestController
public class EmployeeController {

    //injection une instance de EmployeeService
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public Iterable<Employee> getEmployees(){
        return  employeeService.getEmployee();
    }



    @GetMapping("/employees/{id}")
    public Employee getEmployees(@PathVariable("id ") final Long id){
        Optional<Employee> employee = employeeService.getEmployee(id);
            if(employee.isPresent()){
               return employee.get();
            }else{

                return null;
            }
    }


    @PostMapping("/employee")
    public Employee createEmployee (@RequestBody  Employee employee){

        return employeeService.saveEmployee(employee);
    }


    @PutMapping("/employee/{id}")
    public Employee updateEmployee (@PathVariable("id") final Long id ,@RequestBody Employee employee){
        Optional <Employee> e = employeeService.getEmployee(id);
        if(e.isPresent()){
            Employee currentEmployee = e.get();

            String firstName = employee.getFirstName();
            if(firstName != null){
                currentEmployee.setFirstName(firstName);
            }

            String lastName = employee.getLastName();
            if(lastName  != null){
                currentEmployee.setFirstName(lastName);
            }

            String email = employee.getEmail();
            if(email != null){
                currentEmployee.setFirstName(email);
            }

            String password = employee.getPassword();
            if(password != null){
                currentEmployee.setFirstName(password);
            }
            employeeService.saveEmployee(currentEmployee);
            return currentEmployee;

        }else {
            return null;
        }
    }



    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@RequestBody final Long id){

        employeeService.deleteEmployee(id);
    }





}
