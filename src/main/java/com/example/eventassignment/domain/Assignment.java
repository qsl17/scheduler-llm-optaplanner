package com.example.eventassignment.models;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Assignment {
    private Event event;
    @PlanningVariable(valueRangeProviderRefs = {"personRange"})
    private Person person;

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}
