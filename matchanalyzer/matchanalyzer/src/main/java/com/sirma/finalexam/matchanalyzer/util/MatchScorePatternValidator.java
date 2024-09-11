package com.sirma.finalexam.matchanalyzer.util;

import com.sirma.finalexam.matchanalyzer.interfaces.PatternValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchScorePatternValidator implements PatternValidator<String> {
    //pattern to match the score, spent an hour designing it
    private final static Pattern MATCH_SCORE_PATTERN
            = Pattern.compile("((0|[1-9]\\d*)(\\((0|[1-9]\\d*)\\))?-(0|[1-9]\\d*)(\\((0|[1-9]\\d*)\\))?)");


    @Override
    public String validate(String data) {
        Matcher matcher = MATCH_SCORE_PATTERN.matcher(data);
        if(!matcher.matches())
        {
            return null;
        }
        return data;
    }
}
