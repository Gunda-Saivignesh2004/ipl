package com.edutech.progressive.service;

import com.edutech.progressive.entity.Cricketer;

import java.sql.SQLException;
import java.util.List;

public interface CricketerService {

    List<Cricketer> getAllCricketers() throws SQLException;

    Integer addCricketer(Cricketer cricketer) throws SQLException;

    List<Cricketer> getAllCricketersSortedByExperience() throws SQLException;

    default void emptyArrayList() {}

    default void updateCricketer(Cricketer cricketer) throws SQLException {}

    default void deleteCricketer(int cricketerId) throws SQLException {}

    default Cricketer getCricketerById(int cricketerId) throws SQLException { return null; }

    default List<Cricketer> getCricketersByTeam(int teamId) throws SQLException { return null; }
}