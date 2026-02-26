package com.edutech.progressive.service;
import com.edutech.progressive.entity.Team;
import java.sql.SQLException;
import java.util.List;

public interface TeamService {
    List<Team> getAllTeams() throws SQLException;
    int addTeam(Team team) throws SQLException;
    List<Team> getAllTeamsSortedByName() throws SQLException;
    Team getTeamById(int teamId) throws SQLException;
    void updateTeam(Team team) throws SQLException;
    void deleteTeam(int teamId) throws SQLException;
    void emptyArrayList();
}