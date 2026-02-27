package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/cricketer")
public class CricketerController {

    private final CricketerService cricketerService;

    public CricketerController(CricketerService cricketerService) {
        this.cricketerService = cricketerService;
    }

    // GET /cricketer
    @GetMapping
    public ResponseEntity<List<Cricketer>> getAllCricketers() {
        try {
            return ResponseEntity.ok(cricketerService.getAllCricketers());
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /cricketer/{cricketerId}
    @GetMapping("/{cricketerId}")
    public ResponseEntity<Cricketer> getCricketerById(@PathVariable int cricketerId) {
        try {
            Cricketer c = cricketerService.getCricketerById(cricketerId);
            return ResponseEntity.ok(c);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // POST /cricketer
    @PostMapping
    public ResponseEntity<Integer> addCricketer(@RequestBody Cricketer cricketer) {
        try {
            Integer id = cricketerService.addCricketer(cricketer);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // PUT /cricketer/{cricketerId}
    @PutMapping("/{cricketerId}")
    public ResponseEntity<Void> updateCricketer(@PathVariable int cricketerId, @RequestBody Cricketer cricketer) {
        try {
            cricketer.setCricketerId(cricketerId);
            cricketerService.updateCricketer(cricketer);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // DELETE /cricketer/{cricketerId}
    @DeleteMapping("/{cricketerId}")
    public ResponseEntity<Void> deleteCricketer(@PathVariable int cricketerId) {
        try {
            cricketerService.deleteCricketer(cricketerId);
            return ResponseEntity.noContent().build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /cricketer/team/{teamId} AND /cricketer/cricketer/team/{teamId}
    @GetMapping({"/team/{teamId}", "/cricketer/team/{teamId}", "/cricketer/cricketer/team/{teamId}"})
    public ResponseEntity<List<Cricketer>> getCricketersByTeam(@PathVariable int teamId) {
        try {
            List<Cricketer> list = cricketerService.getCricketersByTeam(teamId);
            return ResponseEntity.ok(list); // 200 OK with [] if none
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}