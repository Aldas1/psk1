package org.example.web.students;

import org.example.entities.Student;
import org.example.usecases.StudentsUseCases;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class StudentBean {

    @Inject
    private StudentsUseCases studentsUseCases;

    private List<Student> students;

    @PostConstruct
    public void init() {
        students = studentsUseCases.getAllStudents();
    }

    public List<Student> getStudents() {
        return students;
    }
}