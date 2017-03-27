/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advdb.footballclub.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author apichart
 */

@Entity
@Table(name = "dim_competition")
public class DimCompetition implements Serializable{
    
    private int competitionKy;
    private String competiotionName;
    private String seasonName;
    private int seasonStartYear;
    private int seasonEndYear;

    public DimCompetition() {
    }

    public DimCompetition(String competiotionName, String seasonName, int seasonStartYear, int seasonEndYear) {
        this.competiotionName = competiotionName;
        this.seasonName = seasonName;
        this.seasonStartYear = seasonStartYear;
        this.seasonEndYear = seasonEndYear;
    }
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, nullable = false)
    public int getCompetitionKy() {
        return competitionKy;
    }

    public void setCompetitionKy(Integer competitionKy) {
        this.competitionKy = competitionKy;
    }

    @Column(unique = true, nullable = false)
    public String getCompetiotionName() {
        return competiotionName;
    }

    public void setCompetiotionName(String competiotionName) {
        this.competiotionName = competiotionName;
    }

    @Column(unique = true, nullable = false)
    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    @Column(unique = true, nullable = false)
    public int getSeasonStartYear() {
        return seasonStartYear;
    }

    public void setSeasonStartYear(int seasonStartYear) {
        this.seasonStartYear = seasonStartYear;
    }

    @Column(unique = true, nullable = false)
    public int getSeasonEndYear() {
        return seasonEndYear;
    }

    public void setSeasonEndYear(int seasonEndYear) {
        this.seasonEndYear = seasonEndYear;
    }
    
    
    
    
}
