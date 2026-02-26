package com.edutech.progressive.repository;

import com.edutech.progressive.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team findByTeamId(int teamId);
}