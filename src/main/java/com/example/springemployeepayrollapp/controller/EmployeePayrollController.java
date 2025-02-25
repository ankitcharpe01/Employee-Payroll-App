package com.example.springemployeepayrollapp.controller;

import com.example.springemployeepayrollapp.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }

    @PostMapping("/add")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }

    @PutMapping("/update")
    public String updateEmployee() {
        return "Employee updated successfully!";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee() {
        return "Employee deleted successfully!";
    }
}
