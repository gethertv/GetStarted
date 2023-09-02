package dev.gether.GetStarted.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*
    @Primary
     primary - ustawia sie gdy interface ma wiecej niz jedna implementacje
     i gdy chcemy aby domyslnie class CricketCoach byla jego implementacja
     mozemy tez uzyc @Qualifier("nazwaKlasy")
*/
@Component
public class CricketCoach implements Coach {

    public CricketCoach()
    {
        System.out.println("# elo");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice bowling for 15 min";
    }
}
