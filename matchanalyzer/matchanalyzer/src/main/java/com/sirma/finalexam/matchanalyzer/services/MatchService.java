package com.sirma.finalexam.matchanalyzer.services;

import com.sirma.finalexam.matchanalyzer.dtos.create.CreateMatchDTO;
import com.sirma.finalexam.matchanalyzer.entities.Match;
import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.exceptions.*;
import com.sirma.finalexam.matchanalyzer.repositories.MatchRepository;
import com.sirma.finalexam.matchanalyzer.repositories.TeamRepository;
import com.sirma.finalexam.matchanalyzer.util.MatchDatePatternValidator;
import com.sirma.finalexam.matchanalyzer.util.MatchScorePatternValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    //ID,ATeamID,BTeamID,Date,Score

    private static final Logger LOGGER = LoggerFactory.getLogger(MatchService.class);
    private MatchRepository matchRepository;
    private TeamRepository teamRepository;
    private MatchDatePatternValidator matchDateValidator;
    private MatchScorePatternValidator matchScoreValidator;
    private IdGenerationService<Match> idGenerationService;

    public MatchService(MatchRepository matchRepository,
                        TeamRepository teamRepository,
                        MatchDatePatternValidator matchDatePatternValidator,
                        MatchScorePatternValidator matchScorePatternValidator,
                        IdGenerationService<Match> idGenerationService) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.matchDateValidator = matchDatePatternValidator;
        this.matchScoreValidator = matchScorePatternValidator;
        this.idGenerationService = idGenerationService;
    }

    public List<Match> getAllMatches()
    {
        List<Match> matches = this.matchRepository.findAll();
        return matches;
    }

    public Match getMatchById(Long matchId)
    {
        try {
            return this.matchRepository.findById(matchId)
                    .orElseThrow(() -> new MatchNotFoundException("Match with ID: " + matchId + " does not exist."));
        } catch (MatchNotFoundException e) {
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    @Transactional
    public Match createMatch(CreateMatchDTO matchDTO)
    {
        //check if teamA exists
        //check if teamB exists
        //parse String Date to LocalDate(for now just one format as shown in the CSV)
        //Check if Score is valid by using regex(Create a class to check this, the regex is found in the CSV match parser)
        Long aTeamId = matchDTO.getATeamId();
        Long bTeamId = matchDTO.getBTeamId();
        //LOGGER.info("Team a id:{} team b id:{}", aTeamId, bTeamId);
        String score = matchDTO.getScore();
        //LOGGER.info(score);
        String date = matchDTO.getDate();
        //LOGGER.info(date);
        LocalDate matchDate = matchDateValidator.validate(date);

        try {
            if(matchScoreValidator.validate(score) == null)
            {
                throw new InvalidMatchFormatException("Match score is not formatted correctly or invalid.");
            }
            if(matchDate == null)
            {
                throw new InvalidMatchFormatException("Match date is not formatted correctly or invalid.");
            }

            Team teamA = teamRepository.findById(aTeamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID " + aTeamId + " not found."));
            Team teamB = teamRepository.findById(bTeamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID " + bTeamId + " not found."));

            Match match = new Match();
            match.setId(generateUniqueId());
            match.setTeamA(teamA);
            match.setTeamB(teamB);
            match.setDate(matchDate);
            match.setScore(score);
            return this.matchRepository.save(match);

        } catch (MatchNotFoundException e) {
            throw new MatchNotFoundException(e.getMessage());
        } catch (InvalidMatchFormatException e) {
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    @Transactional
    public Match updateMatch(Long matchId, CreateMatchDTO updatedMatch) {

        Long aTeamId = updatedMatch.getATeamId();
        Long bTeamId = updatedMatch.getBTeamId();
        //LOGGER.info("Team a id: {} team b id: {}", aTeamId, bTeamId);
        String score = updatedMatch.getScore();
        String date = updatedMatch.getDate();
        LocalDate matchDate = matchDateValidator.validate(date);

        try {
            if (matchScoreValidator.validate(score) == null) {
                throw new InvalidMatchFormatException("Match score is not formatted correctly or invalid.");
            }
            //LOGGER.info("Passed score validation");
            if (matchDate == null) {
                throw new InvalidMatchFormatException("Match date is not formatted correctly or invalid.");
            }
            //LOGGER.info("Passed date validation");

            Match match = matchRepository.findById(matchId)
                    .orElseThrow(() -> new MatchNotFoundException("Match with ID " + matchId + " does not exist."));
            //LOGGER.info("Found match with id " + matchId);

            Team teamA = teamRepository.findById(aTeamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID " + aTeamId + " not found."));
            //LOGGER.info("Found team with id of team a");
            Team teamB = teamRepository.findById(bTeamId)
                    .orElseThrow(() -> new TeamNotFoundException("Team with ID " + bTeamId + " not found."));
            //LOGGER.info("Found team with id of team b");

            // Update match fields
            match.setTeamA(teamA);
            match.setTeamB(teamB);
            match.setDate(matchDate);
            match.setScore(score);

            return this.matchRepository.save(match);

        } catch (RuntimeException e) {
            LOGGER.warn(e.getMessage());
            return null;
        }
    }


    //add authorization so only admins can delete
    public boolean deleteMatchById(Long matchId)
    {
        try {
            Match match = this.matchRepository.findById(matchId).orElseThrow(() -> new MatchNotFoundException("Match with ID "
                    + matchId + " not found."));
            this.matchRepository.delete(match);
            return true;
        } catch (MatchNotFoundException e) {
            return false;
        }
    }

    private Long generateUniqueId() {
        return this.idGenerationService.generateUniqueId(matchRepository);
    }
}