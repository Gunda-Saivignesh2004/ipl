package com.edutech.progressive.service.impl;
import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.repository.CricketerRepository;
import com.edutech.progressive.service.CricketerService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class CricketerServiceImplJpa implements CricketerService {

    private CricketerRepository cricketerRepository;

    public CricketerServiceImplJpa() {}

    public CricketerServiceImplJpa(CricketerRepository repo) {
        this.cricketerRepository = repo;
    }

    public void setCricketerRepository(CricketerRepository repo) {
        this.cricketerRepository = repo;
    }

    @Override
    public List<Cricketer> getAllCricketers() throws SQLException {
        // Day 6: placeholder
        return Collections.emptyList();
    }

    @Override
    public Integer addCricketer(Cricketer cricketer) throws SQLException {
        // Day 6: placeholder
        return -1;
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() throws SQLException {
        // Day 6: placeholder
        return Collections.emptyList();
    }

   @Override
public void emptyArrayList() {
    // JPA-backed service has no in-memory store to clear.
    // This is intentionally a no-op to satisfy the interface.
}
}