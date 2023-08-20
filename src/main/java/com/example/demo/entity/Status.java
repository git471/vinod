package com.example.demo.entity;

public enum Status {
   OPEN("Open"),
    ASSIGNED("Assigned"),
    IN_PROGRESS("InProgress"),
    CLOSED("Closed");
    String type;
    Status(String closed) {
        this.type=closed;
    }
}
