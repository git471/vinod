package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Employee_Status;
import com.example.demo.entity.Status;
import com.example.demo.entity.Tasks;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.TasksRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TasksService tasksService;
    @GetMapping("/id/{id}")
    public Employee_Status getEmployeeStatus(@PathVariable Integer id){
        return employeeService.getEmployeeStatus(id);
    }
    @GetMapping("/status/{status}")
    public List<Employee> getEmployeesByStatus(@PathVariable String status){
        Employee_Status status1=Employee_Status.fromString(status);
        return employeeService.getEmployeesByStatus(status1);
    }
    @GetMapping("/")
    public List<Employee> getEmployeesByStatusFree(){
        return employeeRepository.findFreeEmployee();
    }
    @GetMapping("/assign")
    public String check(){
        return tasksService.check();
    }

}
