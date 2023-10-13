package com.crud.mappings.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {


    //define fields

    //annotate the fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private  String course;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    //create constructor

    public Course() {
    }

    public Course(String course) {
        this.course = course;
    }

    //generate getter/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


    // create toString() method

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course='" + course + '\'' +
                '}';
    }



}
