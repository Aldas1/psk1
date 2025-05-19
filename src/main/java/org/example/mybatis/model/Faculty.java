package org.example.mybatis.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Faculty {
    private Integer id;
    private String name;
    private Date createdAt;

    // Gali būti užkrauti per atskirą užklausą
    private List<Student> students;
    private List<Course> courses;
}
