package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Employee_Status;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee_Status getEmployeeStatus(int id){
        return employeeRepository.findById(id).get().getStatus();
    }

    public List<Employee> getEmployeesByStatus(Employee_Status status){
        return employeeRepository.findEmployeeByStatus(status);
    }
    public void updateStatus(Employee employee){
        Employee employee1=employeeRepository.findById(employee.getEid()).get();
        employee1.setStatus(employee.getStatus());
        employeeRepository.save(employee1);
    }
}
