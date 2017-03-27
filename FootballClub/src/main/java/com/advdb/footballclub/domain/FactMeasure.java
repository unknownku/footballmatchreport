/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advdb.footballclub.domain;

/**
 *
 * @author apichart
 */
public class FactMeasure {
    
    private int fullTimeGoals;
    private int halfTimeGoals;
    private int shot;
    private int onTarget;
    private int OffTarget;
    private int cornner;
    private int foul;
    private int yellowCard;
    private int redCard;

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
        return OffTarget;
    }

    public void setOffTarget(int OffTarget) {
        this.OffTarget = OffTarget;
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
        return "FactMeasure{" + "fullTimeGoals=" + fullTimeGoals + ", halfTimeGoals=" + halfTimeGoals + ", shot=" + shot + ", onTarget=" + onTarget + ", OffTarget=" + OffTarget + ", cornner=" + cornner + ", foul=" + foul + ", yellowCard=" + yellowCard + ", redCard=" + redCard + '}';
    }

    
}
