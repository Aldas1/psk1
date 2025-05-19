package org.example.usecases;

import org.example.entities.Course;
import org.example.services.CoursesService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CoursesUseCases {

    @Inject
    private CoursesService coursesService;

    public List<Course> getAllCourses() {
        return coursesService.getAllCourses();
    }

    public Course getCourseById(Integer id) {
        return coursesService.getCourseById(id);
    }

    public List<Course> getCoursesByFacultyId(Integer facultyId) {
        return coursesService.getCoursesByFacultyId(facultyId);
    }

    public void createCourse(Course course) {
        coursesService.createCourse(course);
    }

    public Course updateCourse(Course course) {
        return coursesService.updateCourse(course);
    }

    public void deleteCourse(Integer id) {
        coursesService.deleteCourse(id);
    }
}