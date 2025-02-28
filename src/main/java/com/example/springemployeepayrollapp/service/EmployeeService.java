package com.example.springemployeepayrollapp.service;

import com.example.springemployeepayrollapp.dto.EmployeeDTO;
import com.example.springemployeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 1;

    // Create Employee
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(idCounter++, employeeDTO.getName(), employeeDTO.getSalary());
        employeeList.add(employee);
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }

    // Get all Employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get Employee by ID
    public Employee getEmployeeById(Long id) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    // Update Employee by ID
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                emp.setName(employeeDTO.getName());
                emp.setSalary(employeeDTO.getSalary());
                return new EmployeeDTO(emp.getName(), emp.getSalary());
            }
        }
        return null;
    }

    // Delete Employee by ID
    public boolean deleteEmployee(Long id) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                employeeList.remove(emp);
                return true;
            }
        }
        return false;
    }
}
