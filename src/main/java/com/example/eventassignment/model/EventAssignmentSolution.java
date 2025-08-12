package com.example.eventassignment.model;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.constraintweight.ConstraintConfigurationProvider;

import java.util.List;

@PlanningSolution
public class EventAssignmentSolution {
    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "personRange")
    private List<Person> personList;

    @PlanningEntityCollectionProperty
    private List<Assignment> assignmentList;

    @PlanningScore
    private HardSoftScore score;

    @ConstraintConfigurationProvider
    private ConstraintSettings constraintSettings;

    public java.util.List<Person> getPersonList() { return personList; }
    public void setPersonList(java.util.List<Person> personList) { this.personList = personList; }
    public java.util.List<Assignment> getAssignmentList() { return assignmentList; }
    public void setAssignmentList(java.util.List<Assignment> assignmentList) { this.assignmentList = assignmentList; }
    public org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore getScore() { return score; }
    public void setScore(org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore score) { this.score = score; }
    public ConstraintSettings getConstraintSettings() { return constraintSettings; }
    public void setConstraintSettings(ConstraintSettings constraintSettings) { this.constraintSettings = constraintSettings; }
}
