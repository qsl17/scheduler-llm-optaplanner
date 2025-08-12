package com.example.eventassignment.model;

import java.time.LocalDateTime;

public class Event {
    private Long id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private String requiredRole;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public java.time.LocalDateTime getStart() { return start; }
    public void setStart(java.time.LocalDateTime start) { this.start = start; }
    public java.time.LocalDateTime getEnd() { return end; }
    public void setEnd(java.time.LocalDateTime end) { this.end = end; }
    public String getRequiredRole() { return requiredRole; }
    public void setRequiredRole(String requiredRole) { this.requiredRole = requiredRole; }
}
