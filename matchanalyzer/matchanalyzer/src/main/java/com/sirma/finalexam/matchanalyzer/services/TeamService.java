package com.sirma.finalexam.matchanalyzer.services;

import com.sirma.finalexam.matchanalyzer.dtos.create.CreateTeamDTO;
import com.sirma.finalexam.matchanalyzer.entities.Team;
import com.sirma.finalexam.matchanalyzer.exceptions.TeamNotFoundException;
import com.sirma.finalexam.matchanalyzer.repositories.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    //ID,Name,ManagerFullName,Group

    private TeamRepository teamRepository;
    private IdGenerationService<Team> idGenerationService;

    public TeamService(TeamRepository teamRepository, IdGenerationService<Team> idGenerationService) {
        this.teamRepository = teamRepository;
        this.idGenerationService = idGenerationService;
    }

    //implement returning responses if needed
    public List<Team> getAllTeams()
    {
        List<Team> teams = this.teamRepository.findAll();
        return teams;
    }

    public Optional<Team> getTeamById(Long teamId)
    {
        return this.teamRepository.findById(teamId);
    }

    public Team createTeam(CreateTeamDTO teamDTO)
    {
        //add validation to see if manager already has a team
        //logic to get a unique id
        //save
        Team team = new Team();
        team.setId(generateUniqueId());
        team.setGroupName(teamDTO.getGroupName());
        team.setName(teamDTO.getName());
        team.setManagerFullName(teamDTO.getManagerFullName());
        return this.teamRepository.save(team);
    }

    @Transactional
    public Team updateTeam(Long teamId, CreateTeamDTO updatedTeam)
    {
        //add validation to see if manager already has a team
        Team team = this.teamRepository.findById(teamId).orElseThrow();
        team.setGroupName(updatedTeam.getGroupName());
        team.setName(updatedTeam.getName());
        team.setManagerFullName(updatedTeam.getManagerFullName());
        this.teamRepository.save(team);

        return team;
    }

    //add authorization so only admins can delete
    public boolean deleteTeamById(Long teamId)
    {
        try {
            Team team = this.teamRepository.findById(teamId).orElseThrow(() -> new TeamNotFoundException("Team with ID "
                    + teamId + " not found."));
            this.teamRepository.delete(team);
            return true;
        } catch (TeamNotFoundException e) {
            return false;
        }
    }

    private Long generateUniqueId()
    {
        return this.idGenerationService.generateUniqueId(teamRepository);
    }
}
