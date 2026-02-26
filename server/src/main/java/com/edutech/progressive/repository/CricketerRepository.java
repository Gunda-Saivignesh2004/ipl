package com.edutech.progressive.repository;

import com.edutech.progressive.entity.Cricketer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CricketerRepository extends JpaRepository<Cricketer, Integer> {
    // Day-6: base CRUD only
}
