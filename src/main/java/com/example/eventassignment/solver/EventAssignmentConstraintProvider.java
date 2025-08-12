package com.example.eventassignment.solver;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.ConstraintCollectors;

import com.example.eventassignment.model.Assignment;
import com.example.eventassignment.model.ConstraintSettings;
import com.example.eventassignment.model.Event;
import com.example.eventassignment.model.EventAssignmentSolution;
import com.example.eventassignment.model.Person;

public class EventAssignmentConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory factory) {
        return new Constraint[] {
            personRoleMustMatchEventRole(factory),
            noOverlappingAssignments(factory),
            avoidBackToBackAssignments(factory),
            balanceAssignments(factory)
        };
    }

    private Constraint personRoleMustMatchEventRole(ConstraintFactory factory) {
        return factory.forEach(Assignment.class)
            .filter(assignment -> {
                Person person = assignment.getPerson();
                Event event = assignment.getEvent();
                return person != null && event != null &&
                       !person.getRoles().contains(event.getRequiredRole());
            })
            .penalizeConfigurable(ConstraintSettings.ROLE_MATCH);
    }
    private Constraint balanceAssignments(ConstraintFactory factory) {
        return factory.forEach(Assignment.class)
            .groupBy(Assignment::getPerson, ConstraintCollectors.count())
            .filter((person, count) -> person != null)
            .penalizeConfigurable(ConstraintSettings.BALANCE, (person, count) -> count * count);
    }
    private Constraint noOverlappingAssignments(ConstraintFactory factory) {
        return factory.forEachUniquePair(Assignment.class,
                org.optaplanner.core.api.score.stream.Joiners.equal(Assignment::getPerson)
        )
        .filter((a1, a2) -> {
            Event e1 = a1.getEvent();
            Event e2 = a2.getEvent();
            if (e1 == null || e2 == null) return false;
            return e1.getStart().isBefore(e2.getEnd()) && e2.getStart().isBefore(e1.getEnd());
        })
        .penalizeConfigurable(ConstraintSettings.NO_OVERLAP);
    }
    private Constraint avoidBackToBackAssignments(ConstraintFactory factory) {
        return factory.forEachUniquePair(Assignment.class,
                org.optaplanner.core.api.score.stream.Joiners.equal(Assignment::getPerson)
        )
        .filter((a1, a2) -> {
            Event e1 = a1.getEvent();
            Event e2 = a2.getEvent();
            if (e1 == null || e2 == null) return false;
            return e1.getEnd().equals(e2.getStart()) || e2.getEnd().equals(e1.getStart());
        })
        .penalizeConfigurable(ConstraintSettings.NO_BACK_TO_BACK);
    }
}
