package com.edutech.progressive.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private int matchId;

    // Primitive FK fields (needed by older tests/DAO)
    @Column(name = "first_team_id", nullable = false)
    private int firstTeamId;

    @Column(name = "second_team_id", nullable = false)
    private int secondTeamId;

    @Column(name = "winner_team_id")
    private int winnerTeamId;

    // Associations (Day 7) — read-only view of the same columns
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "first_team_id", insertable = false, updatable = false, nullable = false)
    @JsonBackReference(value = "team-first-matches")
    private Team firstTeam;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "second_team_id", insertable = false, updatable = false, nullable = false)
    @JsonBackReference(value = "team-second-matches")
    private Team secondTeam;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "winner_team_id", insertable = false, updatable = false)
    @JsonBackReference(value = "team-winner-matches")
    private Team winnerTeam;

    @Temporal(TemporalType.DATE)
    @Column(name = "match_date", nullable = false)
    private Date matchDate;

    @Column(name = "venue", length = 100)
    private String venue;

    @Column(name = "result", length = 100)
    private String result;

    /**
     * NOTE: use exact strings: "Pending", "Scheduled", "Completed"
     */
    @Column(name = "status", length = 100)
    private String status;

    public Match() { }

    public Match(int matchId, int firstTeamId, int secondTeamId, Date matchDate,
                 String venue, String result, String status, int winnerTeamId) {
        this.matchId = matchId;
        this.firstTeamId = firstTeamId;
        this.secondTeamId = secondTeamId;
        this.matchDate = matchDate;
        this.venue = venue;
        this.result = result;
        this.status = status;
        this.winnerTeamId = winnerTeamId;
    }

    // Getters & Setters
    public int getMatchId() { return matchId; }
    public void setMatchId(int matchId) { this.matchId = matchId; }

    public int getFirstTeamId() { return firstTeamId; }
    public void setFirstTeamId(int firstTeamId) { this.firstTeamId = firstTeamId; }

    public int getSecondTeamId() { return secondTeamId; }
    public void setSecondTeamId(int secondTeamId) { this.secondTeamId = secondTeamId; }

    public int getWinnerTeamId() { return winnerTeamId; }
    public void setWinnerTeamId(int winnerTeamId) { this.winnerTeamId = winnerTeamId; }

    public Team getFirstTeam() { return firstTeam; }
    public void setFirstTeam(Team firstTeam) { this.firstTeam = firstTeam; }

    public Team getSecondTeam() { return secondTeam; }
    public void setSecondTeam(Team secondTeam) { this.secondTeam = secondTeam; }

    public Team getWinnerTeam() { return winnerTeam; }
    public void setWinnerTeam(Team winnerTeam) { this.winnerTeam = winnerTeam; }

    public Date getMatchDate() { return matchDate; }
    public void setMatchDate(Date matchDate) { this.matchDate = matchDate; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}