package com.edutech.progressive.service.impl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.repository.TeamRepository;
import com.edutech.progressive.service.TeamService;
@Service
public class TeamServiceImplJpa implements TeamService { 
    private TeamRepository teamRepository;
     @Autowired
    public TeamServiceImplJpa(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    public List<Team> getAllTeams() throws SQLException {
        return teamRepository.findAll();
    }
    public int addTeam(Team team) throws SQLException {
        Team saved = teamRepository.save(team);
        return saved.getTeamId();
    }
    public List<Team> getAllTeamsSortedByName() throws SQLException {
        List<Team> teams = teamRepository.findAll();
        Collections.sort(teams); 
        return teams;
    }
    public Team getTeamById(int teamId) throws SQLException {
        return teamRepository.findByTeamId(teamId);
    }
    public void updateTeam(Team team) throws SQLException {
        teamRepository.save(team);
    }
    public void deleteTeam(int teamId) throws SQLException {
        teamRepository.deleteById(teamId);
    }
}
 
 
 
// package com.edutech.progressive.service.impl;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import org.springframework.stereotype.Service;
// import com.edutech.progressive.entity.Team;
// @Service
// public class TeamServiceImplJpa  {
//     List<Team> t=new ArrayList<>();
//     public List<Team> getAllTeams()throws SQLException
//     {
//         return t;
//     }
//     public int addTeam(Team team)throws SQLException
//     {
//          t.add(team);
//          return t.size();
//     }
//     List<Team> getAllTeamsSortedByName()throws SQLException
//     {
//         Collections.sort(t);
//         return t;
//     }
//     public Team getTeamById(int teamId)throws SQLException
//     {for (Team team : t) {
//         if(team.getTeamId()==teamId)
//         {
//             return team;
//         }
//     }return null;
//     }
//     public void updateTeam(Team team)throws SQLException
//     {
//         for (Team team1 : t) {
//             if(team1.getTeamId()==team.getTeamId())
//             {
//                 team1.setTeamName(team.getTeamName());
//                 team1.setLocation(team.getLocation());
//                 team1.setOwnerName(team.getOwnerName());
//                 team1.setEstablishmentYear(team.getEstablishmentYear());
//             }   
//         }
//     }
//   public void deleteTeam(int teamId)
//   {
//   t.removeIf(team -> team.getTeamId() == teamId);
// }
//   }