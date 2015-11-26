/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.smartpital.model;

/**
 *
 * @author fenius
 */
public class Patient extends Person{
    private String ssn;
    public Patient(String name,String email,String phone,String street,String city,String state,int age,int hnumber,String ssn){
        super(name,email,phone,street,city,state,age,hnumber);
       this.ssn = ssn;
    }

    /**
     * @return the ssn
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
