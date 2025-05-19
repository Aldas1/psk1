package org.example.mybatis.model;

import lombok.Data;

import java.util.List;

@Data
public class Course {
    private Integer id;
    private String title;
    private String description;
    private Integer credits;
    private Integer facultyId; // Aiškus ryšio stulpelis MyBatis

    // Užkraunami per atskirą užklausą
    private Faculty faculty;
    private List<Student> students;
}