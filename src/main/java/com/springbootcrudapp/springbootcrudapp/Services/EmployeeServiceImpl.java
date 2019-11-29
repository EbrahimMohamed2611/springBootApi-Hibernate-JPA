package com.springbootcrudapp.springbootcrudapp.Services;

import com.springbootcrudapp.springbootcrudapp.DAO.EmployeeDAOSpringDataJPA;
import com.springbootcrudapp.springbootcrudapp.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAOSpringDataJPA employeeDAOSpringDataJPA;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAOSpringDataJPA employeeDAOSpringDataJPA) {
        this.employeeDAOSpringDataJPA = employeeDAOSpringDataJPA;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return   employeeDAOSpringDataJPA.findAll();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
          Optional<Employee> result =  employeeDAOSpringDataJPA.findById(employeeId);
          Employee employee = null;
          if(result.isPresent()){
              employee = result.get();

          }else
              throw new RuntimeException("Employee is not found");

        return employee;
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        employeeDAOSpringDataJPA.save(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeDAOSpringDataJPA.deleteById(employeeId);
    }
}
