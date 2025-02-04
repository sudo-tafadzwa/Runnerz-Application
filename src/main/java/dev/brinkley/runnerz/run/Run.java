package dev.brinkley.runnerz.run;

import java.time.LocalDateTime;

public record Run(
        int id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location

) {}
