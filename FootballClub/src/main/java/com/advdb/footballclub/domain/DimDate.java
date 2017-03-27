/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advdb.footballclub.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author apichart
 */

@Entity
@Table(name = "dim_date")
public class DimDate implements Serializable{
    
//    private int dateKy;
    private Date date;
    private int year;
    private int month;
    private int day;
    private String season;

    public DimDate() {
    }

    public DimDate(Date date, int year, int month, int day, String season) {
        this.date = date;
        this.year = year;
        this.month = month;
        this.day = day;
        this.season = season;
    }

//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    @Column(unique = true, nullable = false)
//    public int getDateId() {
//        return dateKy;
//    }
//
//    public void setDateId(int dateId) {
//        this.dateKy = dateId;
//    }
    
    @Id
    @Temporal(TemporalType.DATE)
    @Column(unique = true, nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(unique = true, nullable = false)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(unique = true, nullable = false)
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Column(unique = true, nullable = false)
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    @Column(unique = true, nullable = false)
    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
    
    
}
