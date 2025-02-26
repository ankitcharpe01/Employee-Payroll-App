package com.example.springemployeepayrollapp.service;

import com.example.springemployeepayrollapp.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    // This will manage the employee payroll
    public EmployeeDTO getEmployeeDetails() {
        // Logic to get employee details (for now, returning dummy data)
        return new EmployeeDTO("John Doe", 50000);
    }
}
