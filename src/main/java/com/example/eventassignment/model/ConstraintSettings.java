package com.example.eventassignment.model;

import org.optaplanner.core.api.domain.constraintweight.ConstraintConfiguration;
import org.optaplanner.core.api.domain.constraintweight.ConstraintWeight;

@ConstraintConfiguration
public class ConstraintSettings {
    public static final String ROLE_MATCH = "Person role must match event role";
    public static final String NO_OVERLAP = "No overlapping assignments for the same person";
    public static final String NO_BACK_TO_BACK = "Avoid back-to-back assignments for the same person";
    public static final String BALANCE = "Balance assignments across people";

    // Hard constraints
    @ConstraintWeight(ROLE_MATCH)
    private org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore roleMatchWeight = org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.ONE_HARD;
    @ConstraintWeight(NO_OVERLAP)
    private org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore noOverlapWeight = org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.ONE_HARD;
    @ConstraintWeight(NO_BACK_TO_BACK)
    private org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore noBackToBackWeight = org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.ofHard(10);
    // Soft constraints (0 = off)
    @ConstraintWeight(BALANCE)
    private org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore balanceWeight = org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.ONE_SOFT;

    public org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore getRoleMatchWeight() { return roleMatchWeight; }
    public void setRoleMatchWeight(org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore roleMatchWeight) { this.roleMatchWeight = roleMatchWeight; }
    public org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore getNoOverlapWeight() { return noOverlapWeight; }
    public void setNoOverlapWeight(org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore noOverlapWeight) { this.noOverlapWeight = noOverlapWeight; }
    public org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore getNoBackToBackWeight() { return noBackToBackWeight; }
    public void setNoBackToBackWeight(org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore noBackToBackWeight) { this.noBackToBackWeight = noBackToBackWeight; }
    public org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore getBalanceWeight() { return balanceWeight; }
    public void setBalanceWeight(org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore balanceWeight) { this.balanceWeight = balanceWeight; }
}
