package dev.gether.GetStarted.rest;

import dev.gether.GetStarted.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private Coach coach;
    private Coach anotherCoach;

    @Autowired
    public CoachController(@Qualifier("swimCoach") Coach coach,
                            @Qualifier("baseballCoach") Coach anotherCoach)
    {
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout()
    {
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check()
    {
        return "wtf: Comparing beans: coach == anotherCoach, " + ( coach == anotherCoach );
    }


}
