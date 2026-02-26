package com.edutech.progressive.repository;

import com.edutech.progressive.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer> {
    // Day-6: base CRUD only
}