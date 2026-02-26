package com.edutech.progressive.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team implements Comparable<Team> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int teamId;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "location")
    private String location;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "establishment_year")
    private int establishmentYear;

    public Team() {}

    public Team(int teamId, String teamName, String location, String ownerName, int establishmentYear) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.location = location;
        this.ownerName = ownerName;
        this.establishmentYear = establishmentYear;
    }

    public int getTeamId() { return teamId; }
    public void setTeamId(int teamId) { this.teamId = teamId; }
    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public int getEstablishmentYear() { return establishmentYear; }
    public void setEstablishmentYear(int establishmentYear) { this.establishmentYear = establishmentYear; }

    @Override
    public int compareTo(Team other) {
        if (this.teamName == null && other.teamName == null) return 0;
        if (this.teamName == null) return -1;
        if (other.teamName == null) return 1;
        return this.teamName.compareTo(other.teamName);
    }
}