package dev.gether.GetStarted.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Spend 15 min in batting practice";
    }

    /*
        55. Bean Lifecycle Methods
        AFTER CREATE TO OBJECT | INJECT BEANS
     */
    @PostConstruct
    public void startMyProcess()
    {
        System.out.println("# START");
    }
    /*
        THIS INITIALIZES EARLIER THAN OBJECT WILL BE DELETED
    */
    @PreDestroy
    public void finishMyProcess()
    {
        System.out.println("# FINISH");
    }
}
