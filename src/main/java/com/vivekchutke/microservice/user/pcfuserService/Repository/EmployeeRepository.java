package com.vivekchutke.microservice.user.pcfuserService.Repository;

import com.vivekchutke.microservice.user.pcfuserService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    Employee findByUserName(String userName);

    Employee findByUserNameAndPassword(String userName, String password);
}
