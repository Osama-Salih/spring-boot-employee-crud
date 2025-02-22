package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    EmployeeServiceImpl employeeServiceDAO;

    @Autowired
    public EmployeeRestController(EmployeeServiceImpl employeeServiceImpl) {
        employeeServiceDAO = employeeServiceImpl;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeServiceDAO.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = employeeServiceDAO.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return employee;
    }

   @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        Employee employeeToSave = employeeServiceDAO.save(employee);
        return employeeToSave;
   }

   @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employeeToUpdate = employeeServiceDAO.save(employee);
        return employeeToUpdate;
   }

   @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = this.findById(employeeId);

        employeeServiceDAO.delete(employeeId);
        return "Deleted employee id - " + employeeId;
   }
}
