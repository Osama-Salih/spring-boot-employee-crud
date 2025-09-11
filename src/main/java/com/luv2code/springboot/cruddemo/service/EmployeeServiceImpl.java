//package com.luv2code.springboot.cruddemo.service;
//import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
//import com.luv2code.springboot.cruddemo.entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//
//    private final EmployeeRepository employeeRepository;
//
//    @Autowired
//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return this.employeeRepository.findAll();
//    }
//
//    @Override
//    public Employee findById(Integer id) {
//        Optional<Employee> result = this.employeeRepository.findById(id);
//
//        Employee employee = null;
//        if (result.isPresent()) {
//            employee = result.get();
//        } else {
//            throw new RuntimeException("Employee not found! id - " + id);
//        }
//
//        return employee;
//    }
//
//
//    @Override
//    public Employee save(Employee employee) {
//        return this.employeeRepository.save(employee);
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        this.employeeRepository.deleteById(id);
//    }
//}
