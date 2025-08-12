package com.example.eventassignment.controller;

import java.util.concurrent.ExecutionException;

import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventassignment.model.EventAssignmentSolution;

@RestController
@RequestMapping("/api/assignment")
public class EventAssignmentController {

    @Autowired
    private SolverManager<EventAssignmentSolution, Long> solverManager;

    @PostMapping("/solve")
    public EventAssignmentSolution solve(@RequestBody EventAssignmentSolution problem) throws ExecutionException, InterruptedException {
        // Use a dummy problemId for now (single solve at a time)
        Long problemId = 1L;
        System.out.println("Solving problem with ID: " + problemId);
        try {
            // Wait until the solving ends
            return solverManager.solve(problemId, problem).getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }
    }
}
