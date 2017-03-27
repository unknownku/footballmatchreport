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
@Table(name = "dim_opponent")
public class DimOpponent implements Serializable{
    
    private int opponentKy;
    private String opponentLongName;
    private String opponentShortName;

    public DimOpponent() {
    }

    public DimOpponent(String opponentLongName, String opponentShortName) {
        this.opponentLongName = opponentLongName;
        this.opponentShortName = opponentShortName;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, nullable = false)
    public int getOpponentKy() {
        return opponentKy;
    }

    public void setOpponentKy(int opponentKy) {
        this.opponentKy = opponentKy;
    }

    @Column(unique = true, nullable = false)
    public String getOpponentLongName() {
        return opponentLongName;
    }

    public void setOpponentLongName(String opponentLongName) {
        this.opponentLongName = opponentLongName;
    }

    @Column(unique = true, nullable = false)
    public String getOpponentShortName() {
        return opponentShortName;
    }

    public void setOpponentShortName(String opponentShortName) {
        this.opponentShortName = opponentShortName;
    }
    
}
