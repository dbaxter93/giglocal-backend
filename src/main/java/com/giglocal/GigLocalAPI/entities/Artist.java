package com.giglocal.GigLocalAPI.entities;

import javax.persistence.*;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name="FIRST_NAME", length=35, nullable=false)
    String firstName;
    @Column(name="LAST_NAME", length=35, nullable=false)
    String lastName;
    @Column(name="USERNAME", length=35, nullable=false, unique=true)
    String userName;
    @Column(name="EMAIL", nullable=false, unique=true)
    String emailAddress;
    @Column(name="INSTRUMENT", length=35)
    String instrument;
    @Column(name="IS_ACTIVE")
    boolean isActive = true;

    public Artist(){}

    public Artist(Integer id, String firstName, String lastName, String userName, String emailAddress, String instrument, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.instrument = instrument;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Artist withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Artist withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Artist withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Artist withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public Artist withIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }
}
