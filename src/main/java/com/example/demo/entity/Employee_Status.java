package com.example.demo.entity;

public enum Employee_Status {
    AVAILABLE("Available"),
    ASSIGNED("Assigned"),
    WORKING("Working");
    public String status;
    Employee_Status(String working) {
        this.status=working;
    }
    public static Employee_Status fromString(String status){
        for(Employee_Status status1:Employee_Status.values()){
            if(status1.status.equals(status))
                return status1;
        }
        return null;
    }
}
