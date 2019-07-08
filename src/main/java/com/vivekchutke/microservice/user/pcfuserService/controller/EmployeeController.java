package com.vivekchutke.microservice.user.pcfuserService.controller;

import com.vivekchutke.microservice.user.pcfuserService.Exception.EmployeeNotFoundException;
import com.vivekchutke.microservice.user.pcfuserService.Repository.EmployeeRepository;
import com.vivekchutke.microservice.user.pcfuserService.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@EnableDiscoveryClient
public class EmployeeController implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public Employee insertEmployee(@RequestBody Employee employee) {
        logger.info("Inserting a new employee");
        employee = employeeRepository.save(employee);
        return employee;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        logger.info("Retreiving all employees");
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @GetMapping("/employee/{Id}")
    public Optional<Employee> retrieveEmployeebyId(@PathVariable Integer Id)  {
        Optional<Employee> employeeOptional = employeeRepository.findById(Id);
        if(employeeOptional.get() == null) {
            logger.info("No Employee with this employee Id: "+Id);
            throw new EmployeeNotFoundException("UserName Not found :" + Id);
        }
        return employeeOptional;
    }


    @GetMapping("/employeeName/{userName}")
    public Employee retrieveEmployeeByuserName(@PathVariable String userName)  {
        Employee employee = employeeRepository.findByUserName(userName);
        if(employee ==null)
            throw new EmployeeNotFoundException("User_Id Not found :"+userName);
        return employee;
    }

    @GetMapping("/employee")
    public Employee getEmployeeByUserNameAndPassword(@RequestParam(required = true) String userName, @RequestHeader String password) {

        logger.info("In UserName and Password Validation method");

        Employee employee = employeeRepository.findByUserNameAndPassword(userName, password);
        if(employee ==null)
            throw new EmployeeNotFoundException("User_Id Not found :"+userName);
        return employee;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Pre inserting an employee");
        Employee employee1 = new Employee();
        employee1.setFirstName("Vivek");
        employee1.setDob(new Date());
        employee1.setLastName("Chutke");
        employee1.setPassword("test123");
        employee1.setPhoneNumber("925-964-1456");
        employee1.setUserName("vchutke");
        employee1.setDoj(new Date());

        employeeRepository.save(employee1);

    }

}
