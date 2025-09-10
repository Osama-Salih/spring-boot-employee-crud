//package com.luv2code.springboot.cruddemo.dao;
//import com.luv2code.springboot.cruddemo.entity.Employee;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class EmployeeDaoJpaImpl implements EmployeeDAO {
//
//    EntityManager entityManager;
//
//    @Autowired
//    public EmployeeDaoJpaImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        TypedQuery<Employee> query = this.entityManager
//                                    .createQuery("FROM Employee", Employee.class);
//        List<Employee> employees = query.getResultList();
//        return employees;
//    }
//
//    @Override
//    public Employee findById(Integer id) {
//        return this.entityManager.find(Employee.class, id);
//    }
//
//    @Override
//    public Employee save(Employee employee) {
//        return this.entityManager.merge(employee);
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        Employee employee = this.entityManager.find(Employee.class, id);
//        this.entityManager.remove(employee);
//    }
//}
