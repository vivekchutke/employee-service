package com.vivekchutke.microservice.user.pcfuserService.Exception;

public class EmployeeNotFoundException  extends RuntimeException {


    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
