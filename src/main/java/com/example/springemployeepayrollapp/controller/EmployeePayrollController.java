package com.example.springemployeepayrollapp.controller;

import com.example.springemployeepayrollapp.dto.EmployeeDTO;
import com.example.springemployeepayrollapp.model.Employee;
import com.example.springemployeepayrollapp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeePayrollController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }

    // Create Employee
    @PostMapping("/add")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        log.debug("Received Employee Data: {}", employeeDTO);
        EmployeeDTO savedEmployee= employeeService.addEmployee(employeeDTO);
        log.info("Employee created successfully with ID: {}", savedEmployee.getName());
        return savedEmployee;
    }

    // Get all Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        List<Employee> employees = employeeService.getAllEmployees();
        log.info("Total Employees Retrieved: {}", employees.size());
        return employeeService.getAllEmployees();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with ID : {}", id);
        return employeeService.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        log.info("Fetching employee with ID: {}", id);
        EmployeeDTO employee= employeeService.updateEmployee(id, employeeDTO);
        log.info("Retrieved Employee: {}", employee);
        return  employee;
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        log.warn("Received request to delete employee with ID: {}", id);
        String deleteEmployee= employeeService.deleteEmployee(id) ? "Employee deleted successfully" : "Employee not found";
        log.warn("Employee with ID: {} deleted successfully", id);
        return deleteEmployee;
    }
}
