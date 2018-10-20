package com.dolgov.annotation;


@Table(name = "Persons")
public class Person {

    @Column(name = "person_id")
    int id;

    @Column(name = "person_name")
    String name;

    @Column
    double salary;

}