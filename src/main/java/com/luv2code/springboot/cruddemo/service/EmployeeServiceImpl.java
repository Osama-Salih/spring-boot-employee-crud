package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeJpaImpDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    EmployeeJpaImpDAO employeeJpaImpDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeJpaImpDAO employeeDAO) {
        employeeJpaImpDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeJpaImpDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeJpaImpDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeJpaImpDAO.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeJpaImpDAO.delete(id);
    }
}
