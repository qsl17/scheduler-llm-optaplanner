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

        if (settings != null) {
            System.out.println("Input Balance Weight: " + settings.getBalanceWeight());
            System.out.println("Input Back to Back Weight: " + settings.getNoBackToBackWeight());
            System.out.println("Input Overlap Weight: " + settings.getNoOverlapWeight());
            System.out.println("Input Role Match Weight: " + settings.getRoleMatchWeight());
            // settings.setBalanceWeight(org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.parseScore("0hard/0soft"));
            // settings.setNoBackToBackWeight(org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.parseScore("0hard/0soft"));
            // settings.setNoOverlapWeight(org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.parseScore("1hard/0soft"));
            // settings.setRoleMatchWeight(org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.parseScore("1hard/0soft"));
        }
        if (settings == null) {
            settings = new ConstraintSettings(); // use defaults
            System.out.println("Balance Weight: " + settings.getBalanceWeight());
            System.out.println("Back to Back Weight: " + settings.getNoBackToBackWeight());
            System.out.println("Overlap Weight: " + settings.getNoOverlapWeight());
            System.out.println("Role Match Weight: " + settings.getRoleMatchWeight());
            // Balance Weight: 0hard/1soft
            // Back to Back Weight: 10hard/0soft
            // Overlap Weight: 1hard/0soft
            // Role Match Weight: 1hard/0soft
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
