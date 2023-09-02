package dev.gether.GetStarted.config;

import dev.gether.GetStarted.common.Coach;
import dev.gether.GetStarted.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach()
    {
        return new SwimCoach();
    }
}
