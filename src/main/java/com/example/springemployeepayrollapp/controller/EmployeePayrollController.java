package com.example.springemployeepayrollapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeePayrollController {

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }
}
