package com.edutech.progressive.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edutech.progressive.entity.Cricketer;
@Repository
public interface CricketerRepository extends JpaRepository<Cricketer, Integer> {
    Cricketer findByCricketerId(int cricketerId);
        List<Cricketer> findByTeamId(Integer teamId);
    List<Cricketer> findByTeam_TeamId(int teamId);
}