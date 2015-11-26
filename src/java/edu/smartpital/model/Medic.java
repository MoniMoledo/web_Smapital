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
public class Medic extends Person{
       private String medcode;
       private String specialty;
    public Medic(String name,String email,String phone,String street,String city,String state,int age,int hnumber,String medcode,String specialty){
        super(name,email,phone,street,city,state,age,hnumber);
       this.medcode = medcode;
       this.specialty=specialty;
    }

    /**
     * @return the medcode
     */
    public String getMedcode() {
        return medcode;
    }

    /**
     * @param medcode the medcode to set
     */
    public void setMedcode(String medcode) {
        this.medcode = medcode;
    }

    /**
     * @return the specialty
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * @param specialty the specialty to set
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
