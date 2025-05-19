package org.example.usecases;

import org.example.entities.Student;
import org.example.services.StudentsService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class StudentsUseCases {

    @Inject
    private StudentsService studentsService;

    public List<Student> getAllStudents() {
        return studentsService.getAllStudents();
    }

    public Student getStudentById(Integer id) {
        return studentsService.getStudentById(id);
    }

    public List<Student> getStudentsByFacultyId(Integer facultyId) {
        return studentsService.getStudentsByFacultyId(facultyId);
    }

    public void createStudent(Student student) {
        studentsService.createStudent(student);
    }

    public Student updateStudent(Student student) {
        return studentsService.updateStudent(student);
    }

    public void deleteStudent(Integer id) {
        studentsService.deleteStudent(id);
    }

    public void registerStudentForCourse(Integer studentId, Integer courseId) {
        studentsService.registerStudentForCourse(studentId, courseId);
    }

    public void unregisterStudentFromCourse(Integer studentId, Integer courseId) {
        studentsService.unregisterStudentFromCourse(studentId, courseId);
    }
}