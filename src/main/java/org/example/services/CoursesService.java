package org.example.services;

import org.example.entities.Course;
import org.example.persistence.jpa.CoursesDAOJPA;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CoursesService {

    @Inject
    private CoursesDAOJPA coursesDAO;

    public List<Course> getAllCourses() {
        return coursesDAO.findAll();
    }

    public Course getCourseById(Integer id) {
        return coursesDAO.findById(id);
    }

    public List<Course> getCoursesByFacultyId(Integer facultyId) {
        return coursesDAO.findByFacultyId(facultyId);
    }

    @Transactional
    public void createCourse(Course course) {
        coursesDAO.persist(course);
    }

    @Transactional
    public Course updateCourse(Course course) {
        return coursesDAO.update(course);
    }

    @Transactional
    public void deleteCourse(Integer id) {
        coursesDAO.delete(id);
    }
}