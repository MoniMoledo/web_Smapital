/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.smartpital.model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Monique
 */
public class Appointment {
    
    private int id;
    private Medic med;
    private Patient pat;
    private Date date;
    private Time time;
    private String status;
    private String prescription;

    public Appointment(int id, Medic med, Patient pat, Date date, Time time, String status, String prescription) {
        this.id = id;
        this.med = med;
        this.pat = pat;
        this.date = date;
        this.time = time;
        this.status = status;
        this.prescription = prescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medic getMed() {
        return med;
    }

    public void setMed(Medic med) {
        this.med = med;
    }

    public Patient getPat() {
        return pat;
    }

    public void setPat(Patient pat) {
        this.pat = pat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    
}
