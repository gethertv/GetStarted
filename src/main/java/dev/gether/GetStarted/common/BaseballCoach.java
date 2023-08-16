package dev.gether.GetStarted.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{


    @Override
    public String getDailyWorkout() {
        return "Spend 15 min in batting practice";
    }
}
