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
public abstract class Person {
    private String name;
    private String email;
    private String phone;
    private String street;
    private String city;
    private String state;
    private int age;
    private int hnumber;
    public Person(String name,String email,String phone,String street,String city,String state,int age,int hnumber){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.street=street;
        this.city=city;
        this.state=state;
        this.age=age;
        this.hnumber=hnumber;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the hnumber
     */
    public int getHnumber() {
        return hnumber;
    }

    /**
     * @param hnumber the hnumber to set
     */
    public void setHnumber(int hnumber) {
        this.hnumber = hnumber;
    }
}
