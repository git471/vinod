package com.example.demo.controller;

import com.example.demo.entity.Tasks;
import com.example.demo.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    private TasksService tasksService;
    @GetMapping("/all")
    public List<Tasks> alltasks(){
        return tasksService.getallTasks();
    }
    @GetMapping("/{id}")
    public Tasks taskById(@PathVariable int id){
        return tasksService.findtaskbyId(id);
    }

    @PostMapping("/save")
    public String saveTask(@RequestBody Tasks tasks){
        return tasksService.saveTask(tasks);
    }
    @PutMapping("/edit/{id}")
    public String editTask(@PathVariable int id,@RequestBody Tasks tasks){
        return tasksService.editTask(id,tasks);
    }
    public void handling(){

    }
}
