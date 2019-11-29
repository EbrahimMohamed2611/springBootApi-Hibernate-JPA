package com.springbootcrudapp.springbootcrudapp.Services;

import java.util.List;

import com.springbootcrudapp.springbootcrudapp.Entity.Employee;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int employeeId);

    public void saveOrUpdate(Employee employee);

    public void deleteEmployee(int employeeId);

}
