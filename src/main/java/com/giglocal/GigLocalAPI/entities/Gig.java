package com.giglocal.GigLocalAPI.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Gig {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "TITLE", length = 60, nullable = false)
    String title;
    @Column(name = "DESCRIPTION", length = 255)
    String description;
    @Column(name = "CALL_FOR", length = 60, nullable = false)
    String callFor;
    @Column(name = "DATE", nullable = false)
    String date;
    @Column(name = "POSTED_ON", nullable = false)
    Date posted;
    @Column(name = "IS_ACTIVE", nullable = false)
    boolean isActive = true;

    public Gig(){}

    public Gig(Integer id, String title, String description, String callFor, String date, Date posted, boolean isActive) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.callFor = callFor;
        this.date = date;
        this.posted = posted;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCallFor() {
        return callFor;
    }

    public void setCallFor(String callFor) {
        this.callFor = callFor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Gig withTitle(String title) {
        this.title = title;
        return this;
    }

    public Gig withCallFor(String callFor) {
        this.callFor = callFor;
        return this;
    }

    public Gig withDate(String date) {
        this.date = date;
        return this;
    }

    public Gig withPostedOn(Date posted) {
        this.posted = posted;
        return this;
    }

    public Gig withIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

}
