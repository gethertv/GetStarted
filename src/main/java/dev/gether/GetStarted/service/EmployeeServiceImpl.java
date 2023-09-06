package dev.gether.GetStarted.service;

import dev.gether.GetStarted.dao.EmployeeRepository;
import dev.gether.GetStarted.dao.deprecated.EmployeeDAO;
import dev.gether.GetStarted.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    /*
        DEPRECATED
            private EmployeeDAO employeeDAO;

            @Autowired
            public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
                this.employeeDAO = employeeDAO;
            }

     */


    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent())
        {
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employee;
    }

    @Override
    //@Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    //@Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
