/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advdb.footballclub.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author apichart
 */
@Entity
@Table(name = "fact_match")
public class FactMatch implements Serializable {
    
    @Id
    private int competitionKy;
    @Id
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateKy;
    @Id
    private int opponentKy;    
    @Id
    private int tacticKy;
    @Id
    private int playerKy;
    
    private int fullTimeGoals;
    private int halfTimeGoals;
    private int shot;
    private int onTarget;
    private int offTarget;
    private int cornner;
    private int foul;
    private int yellowCard;
    private int redCard;
    

    public FactMatch() {
    }

    public FactMatch(int competitionKy, Date dateKy, int opponentKy, int tacticKy, int playerKy, int fullTimeGoals, int halfTimeGoals, int shot, int onTarget, int offTarget, int cornner, int foul, int yellowCard, int redCard) {
        this.competitionKy = competitionKy;
        this.dateKy = dateKy;
        this.opponentKy = opponentKy;
        this.tacticKy = tacticKy;
        this.playerKy = playerKy;
        this.fullTimeGoals = fullTimeGoals;
        this.halfTimeGoals = halfTimeGoals;
        this.shot = shot;
        this.onTarget = onTarget;
        this.offTarget = offTarget;
        this.cornner = cornner;
        this.foul = foul;
        this.yellowCard = yellowCard;
        this.redCard = redCard;
    }

    public int getCompetitionKy() {
        return competitionKy;
    }

    public void setCompetitionKy(int competitionKy) {
        this.competitionKy = competitionKy;
    }

    public Date getDateKy() {
        return dateKy;
    }

    public void setDateKy(Date dateKy) {
        this.dateKy = dateKy;
    }

    public int getOpponentKy() {
        return opponentKy;
    }

    public void setOpponentKy(int opponentKy) {
        this.opponentKy = opponentKy;
    }

    public int getTacticKy() {
        return tacticKy;
    }

    public void setTacticKy(int tacticKy) {
        this.tacticKy = tacticKy;
    }

    public int getPlayerKy() {
        return playerKy;
    }

    public void setPlayerKy(int playerKy) {
        this.playerKy = playerKy;
    }

    public int getFullTimeGoals() {
        return fullTimeGoals;
    }

    public void setFullTimeGoals(int fullTimeGoals) {
        this.fullTimeGoals = fullTimeGoals;
    }

    public int getHalfTimeGoals() {
        return halfTimeGoals;
    }

    public void setHalfTimeGoals(int halfTimeGoals) {
        this.halfTimeGoals = halfTimeGoals;
    }

    public int getShot() {
        return shot;
    }

    public void setShot(int shot) {
        this.shot = shot;
    }

    public int getOnTarget() {
        return onTarget;
    }

    public void setOnTarget(int onTarget) {
        this.onTarget = onTarget;
    }

    public int getOffTarget() {
        return offTarget;
    }

    public void setOffTarget(int offTarget) {
        this.offTarget = offTarget;
    }

    public int getCornner() {
        return cornner;
    }

    public void setCornner(int cornner) {
        this.cornner = cornner;
    }

    public int getFoul() {
        return foul;
    }

    public void setFoul(int foul) {
        this.foul = foul;
    }

    public int getYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(int yellowCard) {
        this.yellowCard = yellowCard;
    }

    public int getRedCard() {
        return redCard;
    }

    public void setRedCard(int redCard) {
        this.redCard = redCard;
    }

    @Override
    public String toString() {
        return "FactMatch2{" + "competitionKy=" + competitionKy + ", dateKy=" + dateKy + ", opponentKy=" + opponentKy + ", tacticKy=" + tacticKy + ", playerKy=" + playerKy + ", fullTimeGoals=" + fullTimeGoals + ", halfTimeGoals=" + halfTimeGoals + ", shot=" + shot + ", onTarget=" + onTarget + ", offTarget=" + offTarget + ", cornner=" + cornner + ", foul=" + foul + ", yellowCard=" + yellowCard + ", redCard=" + redCard + '}';
    }
    
    
}
