package com.example.eventassignment.model;

import java.util.List;

public class AversionGroup {
    private List<String> personIds;
    public AversionGroup() {}
    public AversionGroup(List<String> personIds) { this.personIds = personIds; }
    public List<String> getPersonIds() { return personIds; }
    public void setPersonIds(List<String> personIds) { this.personIds = personIds; }
}
