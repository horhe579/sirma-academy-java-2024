package com.sirma.finalexam.matchanalyzer.config;

import com.sirma.finalexam.matchanalyzer.util.MatchDatePatternValidator;
import com.sirma.finalexam.matchanalyzer.util.MatchScorePatternValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationConfig {
    //letting the ioc container create beans for validation since i cannot make interface methods static
    @Bean
    public MatchScorePatternValidator matchScorePatternValidator() {
        return new MatchScorePatternValidator();
    }

    @Bean
    public MatchDatePatternValidator matchDatePatternValidator() {
        return new MatchDatePatternValidator();
    }
}
