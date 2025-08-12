package com.example.eventassignment.controller;

import java.util.concurrent.ExecutionException;

import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventassignment.model.ConstraintSettings;
import com.example.eventassignment.model.EventAssignmentSolution;

@RestController
@RequestMapping("/api/assignment")
public class EventAssignmentController {

    @Autowired
    private SolverManager<EventAssignmentSolution, Long> solverManager;

    @PostMapping("/solve")
    public EventAssignmentSolution solve(@RequestBody EventAssignmentSolution problem) throws ExecutionException, InterruptedException {
        ConstraintSettings settings = problem.getConstraintSettings();
        System.out.println("Received problem with constraints: " + settings);
        if (settings == null) {
            settings = new ConstraintSettings(); // use defaults
            problem.setConstraintSettings(settings);
        }
        Long problemId = 1L;
        System.out.println("Solving problem with ID: " + problemId + ", constraints: " + settings);
        try {
            return solverManager.solve(problemId, problem).getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }
    }
}
