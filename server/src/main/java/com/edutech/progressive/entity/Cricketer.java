package com.edutech.progressive.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

@Entity
@Table(name = "cricketer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cricketer implements Comparable<Cricketer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cricketer_id")
    private int cricketerId;

    // Read-only view of the FK for querying/serialization
    @Column(name = "team_id", insertable = false, updatable = false)
    private Integer teamId;

    // Association writes the FK (insertable/updatable = true by default)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    @JsonBackReference(value = "team-cricketers")
    private Team team;

    @Column(name = "cricketer_name", nullable = false, length = 100)
    private String cricketerName;

    @Column(name = "age")
    private int age;

    @Column(name = "nationality", length = 100)
    private String nationality;

    @Column(name = "experience")
    private int experience;

    // Must be one of: "Batsman", "Bowler", "All-rounder", "Wicketkeeper"
    @Column(name = "role", length = 50)
    private String role;

    @Column(name = "total_runs")
    private int totalRuns;

    @Column(name = "total_wickets")
    private int totalWickets;

    public Cricketer() {}

    public Cricketer(int cricketerId, int teamId, String cricketerName, int age,
                     String nationality, int experience, String role,
                     int totalRuns, int totalWickets) {
        this.cricketerId = cricketerId;
        this.teamId = teamId;
        this.cricketerName = cricketerName;
        this.age = age;
        this.nationality = nationality;
        this.experience = experience;
        this.role = role;
        this.totalRuns = totalRuns;
        this.totalWickets = totalWickets;
    }

    public int getCricketerId() { return cricketerId; }
    public void setCricketerId(int cricketerId) { this.cricketerId = cricketerId; }

    public Integer getTeamId() { return teamId; }
    public void setTeamId(Integer teamId) { this.teamId = teamId; }

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }

    public String getCricketerName() { return cricketerName; }
    public void setCricketerName(String cricketerName) { this.cricketerName = cricketerName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getTotalRuns() { return totalRuns; }
    public void setTotalRuns(int totalRuns) { this.totalRuns = totalRuns; }

    public int getTotalWickets() { return totalWickets; }
    public void setTotalWickets(int totalWickets) { this.totalWickets = totalWickets; }

    // Keep FK & association synchronized for POST/PUT that only send teamId
    @PrePersist
    @PreUpdate
    private void syncTeamForeignKey() {
        if (this.team == null && this.teamId != null && this.teamId > 0) {
            Team t = new Team();
            t.setTeamId(this.teamId);
            this.team = t; // JPA will write team_id via association
        } else if (this.team != null) {
            this.teamId = this.team.getTeamId();
        }
    }

    @Override
    public int compareTo(Cricketer other) {
        return Integer.compare(this.experience, other.experience);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cricketer)) return false;
        Cricketer that = (Cricketer) o;
        return cricketerId == that.cricketerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cricketerId);
    }

    @Override
    public String toString() {
        return "Cricketer{" +
                "cricketerId=" + cricketerId +
                ", teamId=" + teamId +
                ", cricketerName='" + cricketerName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", experience=" + experience +
                ", role='" + role + '\'' +
                ", totalRuns=" + totalRuns +
                ", totalWickets=" + totalWickets +
                '}';
    }
}