package com.edutech.progressive.repository;

import com.edutech.progressive.entity.Cricketer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CricketerRepository extends JpaRepository<Cricketer, Integer> {

    Cricketer findByCricketerId(int cricketerId);

    // 1) Scalar-column derived query (robust if rows inserted via JDBC)
    List<Cricketer> findByTeamId(int teamId);

    // 2) Association-based derived query (robust if JPA association is set)
    List<Cricketer> findByTeam_TeamId(int teamId);

    // 3) JPQL explicitly on scalar column
    @Query("SELECT c FROM Cricketer c WHERE c.teamId = :teamId")
    List<Cricketer> selectByTeamId(@Param("teamId") int teamId);

    // 4) Native SQL fallback
    @Query(value = "SELECT * FROM cricketer WHERE team_id = :teamId", nativeQuery = true)
    List<Cricketer> nativeFindByTeamId(@Param("teamId") int teamId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Cricketer c WHERE c.team.teamId = :teamId")
    void deleteByTeamId(@Param("teamId") int teamId);
}