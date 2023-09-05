package dev.gether.GetStarted.dao;


import dev.gether.GetStarted.entity.Employee;

import java.util.List;


public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);
    Employee save(Employee employee);

    void delete(int id);


}