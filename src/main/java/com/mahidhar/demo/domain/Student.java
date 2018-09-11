package com.mahidhar.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;



import java.math.BigDecimal;
import java.util.Date;


import javax.annotation.Generated;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Entity
public class Student  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Size(min=3)
    private String firstName;
    @Size(min=3)
    private String lastName;
    private String enrolledCourse;
    private String batch;
    private String city;

    @JsonFormat(pattern ="MM/dd/yyyy")
    private Date enrolledDate;

    private int postcode;

    public Student() {
    }

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param enrolledCourse
     * @param batch
     * @param city
     * @param enrolledDate
     * @param postcode
     */

    public Student(Long id, String firstName, String lastName, String enrolledCourse, String batch, String city, Date enrolledDate, int postcode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrolledCourse = enrolledCourse;
        this.batch = batch;
        this.city = city;
        this.enrolledDate = enrolledDate;
        this.postcode = postcode;
    }

    public Student(String firstName, String lastName, String enrolledCourse, String batch, String city, Date enrolledDate, int postcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrolledCourse = enrolledCourse;
        this.batch = batch;
        this.city = city;
        this.enrolledDate = enrolledDate;
        this.postcode = postcode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEnrolledCourse(String enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEnrolledDate(Date enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEnrolledCourse() {
        return enrolledCourse;
    }

    public String getBatch() {
        return batch;
    }

    public String getCity() {
        return city;
    }

    public Date getEnrolledDate() {
        return enrolledDate;
    }

    public int getPostcode() {
        return postcode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enrolledCourse='" + enrolledCourse + '\'' +
                ", batch='" + batch + '\'' +
                ", city='" + city + '\'' +
                ", enrolledDate=" + enrolledDate +
                ", postcode=" + postcode +
                '}';
    }
}
