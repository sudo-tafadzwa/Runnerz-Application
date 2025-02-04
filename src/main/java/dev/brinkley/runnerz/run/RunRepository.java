package dev.brinkley.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class RunRepository {
    
    private List<Run> runs  = new ArrayList<>();
    
    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(int id) {
        return runs.stream()
                .filter(r -> r.id() == id)
                .findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }
    
    void update(Run run, Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id){
        runs.removeIf(r -> r.id() == id);
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(
                1, 
                "Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                3,
                Location.OUTDOOR
                ));

        runs.add(new Run(
                2, 
                "Afternoon Run",
                LocalDateTime.now().plusHours(2),
                LocalDateTime.now().plusHours(3),
                5,
                Location.OUTDOOR
                ));

        runs.add(new Run(
                3, 
                "Evening Run",
                LocalDateTime.now().plusHours(4),
                LocalDateTime.now().plusHours(5),
                7,
                Location.INDOOR
                ));
        
        
    }
}
