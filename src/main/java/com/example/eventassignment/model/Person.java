package com.example.eventassignment.model;

import java.util.List;

public class Person {
    private Long _id;
    private String name;
    private List<String> roles;

    public Long get_id() { return _id; }
    public void set_id(Long _id) { this._id = _id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public java.util.List<String> getRoles() { return roles; }
    public void setRoles(java.util.List<String> roles) { this.roles = roles; }
}
