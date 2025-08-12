# Event Assignment Optimizer

This is a Spring Boot application using Gradle and OptaPlanner. It optimizes event assignments: given a list of events (with role requirements) and a list of personnel (each with a list of roles), it balances assignments so that no person is assigned to overlapping events.

## How to Build and Run

1. Build the project:
   ```powershell
   ./gradlew build
   ```
2. Run the application:
   ```powershell
   ./gradlew bootRun
   ```

## Next Steps

- Implement the domain model for events, personnel, and assignments.
- Add OptaPlanner configuration and constraints.
