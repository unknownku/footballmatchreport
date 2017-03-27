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
@Table(name = "dim_player")
public class DimPlayer implements Serializable{
    
    private int playerKy;
    private String name;
    private String nationality;
    private Double value;
    private Double height;
    private Double weight;

    public DimPlayer() {
    }

    public DimPlayer(String name, String nationality, Double value, Double height, Double weight) {
        this.name = name;
        this.nationality = nationality;
        this.value = value;
        this.height = height;
        this.weight = weight;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, nullable = false)
    public int getPlayerKy() {
        return playerKy;
    }

    public void setPlayerKy(int playerKy) {
        this.playerKy = playerKy;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(unique = true, nullable = false)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(unique = true, nullable = false)
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Column(unique = true, nullable = false)
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Column(unique = true, nullable = false)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
}
