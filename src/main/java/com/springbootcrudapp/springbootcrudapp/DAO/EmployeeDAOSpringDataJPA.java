package com.springbootcrudapp.springbootcrudapp.DAO;

import com.springbootcrudapp.springbootcrudapp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAOSpringDataJPA extends JpaRepository<Employee, Integer> {
    // No Need to code any more
}
