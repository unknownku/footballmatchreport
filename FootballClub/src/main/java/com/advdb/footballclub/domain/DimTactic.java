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
@Table(name = "dim_tactic")
public class DimTactic implements Serializable{
    
    private int tacticKy;
    private String tacticName;
    private String tacticInstruction;

    public DimTactic() {
    }

    public DimTactic(String tacticName, String tacticInstruction) {
        this.tacticName = tacticName;
        this.tacticInstruction = tacticInstruction;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, nullable = false)
    public int getTacticKy() {
        return tacticKy;
    }

    public void setTacticKy(int tacticKy) {
        this.tacticKy = tacticKy;
    }

    @Column(unique = true, nullable = false)
    public String getTacticName() {
        return tacticName;
    }

    public void setTacticName(String tacticName) {
        this.tacticName = tacticName;
    }

    @Column(unique = true, nullable = false)
    public String getTacticInstruction() {
        return tacticInstruction;
    }

    public void setTacticInstruction(String tacticInstruction) {
        this.tacticInstruction = tacticInstruction;
    }
    
    
    
}
