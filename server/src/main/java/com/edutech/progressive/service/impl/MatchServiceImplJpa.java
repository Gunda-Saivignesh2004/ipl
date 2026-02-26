package com.edutech.progressive.service.impl;
import com.edutech.progressive.entity.Match;
import com.edutech.progressive.repository.MatchRepository;
import com.edutech.progressive.service.MatchService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class MatchServiceImplJpa implements MatchService {

    private MatchRepository matchRepository;

    public MatchServiceImplJpa() {}

    public MatchServiceImplJpa(MatchRepository repo) {
        this.matchRepository = repo;
    }

    public void setMatchRepository(MatchRepository repo) {
        this.matchRepository = repo;
    }

    @Override
    public List<Match> getAllMatches() throws SQLException {
        // Day 6: placeholder
        return Collections.emptyList();
    }

    @Override
    public Match getMatchById(int matchId) throws SQLException {
        // Day 6: placeholder
        return null;
    }

    @Override
    public Integer addMatch(Match match) throws SQLException {
        // Day 6: placeholder
        return -1;
    }

    @Override
    public void updateMatch(Match match) throws SQLException {
        // Day 6: placeholder
    }

    @Override
    public void deleteMatch(int matchId) throws SQLException {
        // Day 6: placeholder
    }
}