package com.example.demo.scheduler;

import com.example.demo.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    @Autowired
    TasksService tasksService;
    @Scheduled(cron = "*/10 * * * * *")
    public void scheduleTask(){
        tasksService.check();
        System.out.println("running Scheduler");
    }
}
