package org.example.mybatis.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Date registrationDate;
    private Integer facultyId; // Aiškus ryšio stulpelis MyBatis

    // Užkraunami per atskirą užklausą
    private Faculty faculty;
    private List<Course> courses;
}