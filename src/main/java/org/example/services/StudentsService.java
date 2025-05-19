package org.example.services;

import org.example.entities.Course;
import org.example.entities.Student;
import org.example.persistence.jpa.CoursesDAOJPA;
import org.example.persistence.jpa.StudentsDAOJPA;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class StudentsService {

    @Inject
    private StudentsDAOJPA studentsDAO;

    @Inject
    private CoursesDAOJPA coursesDAO;

    public List<Student> getAllStudents() {
        return studentsDAO.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentsDAO.findById(id);
    }

    public List<Student> getStudentsByFacultyId(Integer facultyId) {
        return studentsDAO.findByFacultyId(facultyId);
    }

    @Transactional
    public void createStudent(Student student) {
        studentsDAO.persist(student);
    }

    @Transactional
    public Student updateStudent(Student student) {
        return studentsDAO.update(student);
    }

    @Transactional
    public void deleteStudent(Integer id) {
        studentsDAO.delete(id);
    }

    @Transactional
    public void registerStudentForCourse(Integer studentId, Integer courseId) {
        Student student = studentsDAO.findById(studentId);
        Course course = coursesDAO.findById(courseId);
        if (student != null && course != null) {
            student.getCourses().add(course);
            studentsDAO.update(student);
        }
    }

    @Transactional
    public void unregisterStudentFromCourse(Integer studentId, Integer courseId) {
        Student student = studentsDAO.findById(studentId);
        Course course = coursesDAO.findById(courseId);
        if (student != null && course != null) {
            student.getCourses().removeIf(c -> c.getId().equals(courseId));
            studentsDAO.update(student);
        }
    }
}