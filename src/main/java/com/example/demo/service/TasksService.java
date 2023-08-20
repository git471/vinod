package com.example.demo.service;

import com.example.demo.email.SendEmail;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Employee_Status;
import com.example.demo.entity.Status;
import com.example.demo.entity.Tasks;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {
    @Autowired
    TasksRepository tasksRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    SendEmail sendEmail;
    public List<Tasks> getallTasks(){
       return  tasksRepository.findAll();
    }
    public Tasks findtaskbyId(int id){
        return tasksRepository.findById(id).get();
    }

    public String saveTask(Tasks tasks) {
        tasksRepository.save(tasks);
        return "Task "+tasks.getId()+" is Saved Successfully";
    }

    public String editTask(int id,Tasks tasks) {
        Tasks tasks1=findtaskbyId(id);
        tasks1.setDescription(tasks.getDescription());
        tasks1.setStatus(tasks.getStatus());
        tasks1.setAssigne(tasks.getAssigne());
        tasksRepository.save(tasks1);
        return "Task "+tasks.getId()+" is Updated Successfully";
    }
    public void updateStatus(Tasks tasks){
        Tasks tasks1=tasksRepository.findById(tasks.getId()).get();
        tasks1.setStatus(tasks.getStatus());
        tasksRepository.save(tasks1);
    }
    public List<Tasks> taskByProperty(){
        return tasksRepository.getTasksByproprity();
    }
    public String check(){
        String string="";
        List<Employee> employees=employeeRepository.findFreeEmployee();
        List<Tasks> tasks=taskByProperty();
        for(Tasks tasks1:tasks){
            for(Employee employee:employees){
                if(tasks1.getStatus().toString().equals(Status.ASSIGNED.toString()))
                    break;
                if(employee.getStatus().toString().equals(Employee_Status.AVAILABLE.toString())) {
                    tasks1.setAssigne(employee.getName());
                    tasks1.setStatus(Status.ASSIGNED);
                    editTask(tasks1.getId(),tasks1);
                    employee.setStatus(Employee_Status.ASSIGNED);
                    employeeService.updateStatus(employee);
                    //sendEmail=new SendEmail(employee,tasks1);
                    string+="Task with id "+tasks1.getId()+"is assigned for Employee "+employee.getName()+"\n";
                }
            }
        }
        System.out.println(string);
        return string;
    }
}
