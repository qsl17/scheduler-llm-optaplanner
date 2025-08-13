package com.example.eventassignment.model;

import java.util.List;

public class AffinityGroup {
    private List<String> personIds;
    public AffinityGroup() {}
    public AffinityGroup(List<String> personIds) { this.personIds = personIds; }
    public List<String> getPersonIds() { return personIds; }
    public void setPersonIds(List<String> personIds) { this.personIds = personIds; }
}
