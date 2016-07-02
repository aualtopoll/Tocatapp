package com.tocatapp.tocatapp.models;

import java.util.ArrayList;

public class Musician extends Model {

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private ArrayList<Integer> bandMembersId;
    private ArrayList<Instrument> instruments;
    private ArrayList<Style> styles;

    public Musician() {}

    public ArrayList<Integer> getBandMembersId() {
        return bandMembersId;
    }

    public void setBandMembersId(ArrayList<Integer> bandMembersId) {
        this.bandMembersId = bandMembersId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(ArrayList<Instrument> instruments) {
        this.instruments = instruments;
    }

    public ArrayList<Style> getStyles() {
        return styles;
    }

    public void setStyles(ArrayList<Style> styles) {
        this.styles = styles;
    }
}
