package com.springbootcrudapp.springbootcrudapp.Controller;

import com.springbootcrudapp.springbootcrudapp.Entity.Employee;
import com.springbootcrudapp.springbootcrudapp.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

     private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

// Get all Employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    // Get Employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    // Create new employee
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        // force add id =0 to save instead of update or check
        employee.setId(0);
        employeeService.saveOrUpdate(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        employeeService.saveOrUpdate(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(employee == null) {
            throw new RuntimeException("This Employee is not exist" + employeeId);
        }
        employeeService.deleteEmployee(employeeId);
        return "This Employee has  this id " +employeeId + "is deleted";
    }

}
