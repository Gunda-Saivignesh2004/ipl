package com.edutech.progressive.service.impl;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;
import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.repository.CricketerRepository;
import com.edutech.progressive.service.CricketerService;
@Service
public class CricketerServiceImplJpa implements CricketerService {
    private final CricketerRepository repo;
    public CricketerServiceImplJpa(CricketerRepository repo) {
        this.repo = repo;
    }
    @Override
    public List<Cricketer> getAllCricketers() {
        return repo.findAll();
    }
    @Override
    public Integer addCricketer(Cricketer c) {
     if (c.getTeamId() == null && c.getTeam() != null) {
    c.setTeamId(c.getTeam().getTeamId());
}
        return repo.save(c).getCricketerId();
    }
    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        List<Cricketer> list = repo.findAll();
        list.sort(Comparator.comparing(Cricketer::getExperience));
        return list;
    }
    @Override
    public void updateCricketer(Cricketer c) {
   if (c.getTeamId() == null && c.getTeam() != null) {
    c.setTeamId(c.getTeam().getTeamId());
}
        repo.save(c);
    }

 
@Override
public void deleteCricketer(int id) {
    try {
        repo.deleteById(id);
    } catch (org.springframework.dao.EmptyResultDataAccessException ignored) {
        // idempotent delete: treat as successful even if the id doesn't exist
    }

}
    @Override
    public Cricketer getCricketerById(int id) {
        return repo.findByCricketerId(id);
    }
   @Override
public List<Cricketer> getCricketersByTeam(int teamId) {
    // Use FK column-based method to avoid JOINs (works even if no Team row exists)
    return repo.findByTeamId(teamId);
}
}