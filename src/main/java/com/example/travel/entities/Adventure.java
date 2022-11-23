package com.example.travel.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ADVENTURES")
public class Adventure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="DATE")
    private String date;

    @Column(name="COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "NUM_PHOTOS")
    private Long numPhotos;

    @Column(name = "BLOG_COMPLETED")
    private Boolean blogCompleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getNumPhotos() {
        return numPhotos;
    }

    public void setNumPhotos(Long numPhotos) {
        this.numPhotos = numPhotos;
    }

    public Boolean getBlogCompleted() {
        return blogCompleted;
    }

    public void setBlogCompleted(Boolean blogCompleted) {
        this.blogCompleted = blogCompleted;
    }
}
