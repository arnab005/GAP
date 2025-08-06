package com.arnab.springSecurity.controller;

import com.arnab.springSecurity.model.Employee;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee(123, "Arnab", 100),
            new Employee(124, "Biltu", 200)
    ));

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){

        return employeeList;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/employees")
    public Employee add(@RequestBody Employee employee) {
        employeeList.add(employee);
        System.out.println(employeeList);
        return employee;
    }

}
