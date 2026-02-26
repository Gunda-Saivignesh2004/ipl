package com.edutech.progressive.service.impl;
import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * In-memory Cricketer service for Day-2/5 usage and to compile cleanly against
 * the CricketerService interface on Day-6.
 */
public class CricketerServiceImplArraylist implements CricketerService {

    private List<Cricketer> cricketers = new ArrayList<>();

    // ---------- Day-2/5 expected methods ----------

    @Override
    public List<Cricketer> getAllCricketers() {
        return new ArrayList<>(cricketers);
    }

    @Override
    public Integer addCricketer(Cricketer cricketer) {
        cricketers.add(cricketer);
        return cricketers.size(); // keep behavior similar to Team arraylist impl
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        List<Cricketer> copy = new ArrayList<>(cricketers);
        copy.sort(Comparator.comparingInt(Cricketer::getExperience));
        return copy;
    }

    // Provided as utility to clear the in-memory list
    @Override
    public void emptyArrayList() {
        cricketers = new ArrayList<>();
    }

    // ---------- To satisfy interface abstract methods if not default ----------

    @Override
    public void updateCricketer(Cricketer cricketer) {
        for (int i = 0; i < cricketers.size(); i++) {
            if (cricketers.get(i).getCricketerId() == cricketer.getCricketerId()) {
                Cricketer existing = cricketers.get(i);
                existing.setTeamId(cricketer.getTeamId());
                existing.setCricketerName(cricketer.getCricketerName());
                existing.setAge(cricketer.getAge());
                existing.setNationality(cricketer.getNationality());
                existing.setExperience(cricketer.getExperience());
                existing.setRole(cricketer.getRole());
                existing.setTotalRuns(cricketer.getTotalRuns());
                existing.setTotalWickets(cricketer.getTotalWickets());
                return;
            }
        }
        // If not found, add
        cricketers.add(cricketer);
    }

    @Override
    public void deleteCricketer(int cricketerId) {
        Iterator<Cricketer> it = cricketers.iterator();
        while (it.hasNext()) {
            if (it.next().getCricketerId() == cricketerId) {
                it.remove();
                return;
            }
        }
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) {
        for (Cricketer c : cricketers) {
            if (c.getCricketerId() == cricketerId) return c;
        }
        return null;
    }

    @Override
    public List<Cricketer> getCricketersByTeam(int teamId) {
        List<Cricketer> list = new ArrayList<>();
        for (Cricketer c : cricketers) {
            if (c.getTeamId() == teamId) list.add(c);
        }
        return list;
    }
// Add `throws SQLException` to method signatures if your interface enforces it
}