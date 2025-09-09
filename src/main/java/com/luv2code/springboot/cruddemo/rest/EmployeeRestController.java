package com.luv2code.springboot.cruddemo.rest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("employees/{employeeId}")
    public Employee findOne(@PathVariable int employeeId) {
        Employee employee = this.employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found!");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0);
        return this.employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee updateEmployeeUsingPatch(@PathVariable int employeeId, @RequestBody Map<String, Object> employeeData) {
        Employee employee = this.employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found!");
        }

        if (employeeData.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
        }

        Employee updatedEmployee = apply(employee, employeeData);
        return this.employeeService.save(updatedEmployee);
    }

    private Employee apply(Employee employee, Map<String, Object> employeeData) {
        // Convert employee object to a JSON object node
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);

        // Convert updatedEmpNode object to a JSON object node
        ObjectNode updatedEmpNode = objectMapper.convertValue(employeeData, ObjectNode.class);

        // Merge the patch updates into the employee node
        employeeNode.setAll(updatedEmpNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }


    @DeleteMapping("/employees/{employeeId}")
    public String delete(@PathVariable int employeeId) {
        Employee employee = this.employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found!");
        }

        this.employeeService.deleteById(employeeId);
        return "Deleted employee with id - " + employeeId;
    }
}
