package org.example.rest;

import org.example.entities.Course;
import org.example.usecases.CoursesUseCases;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseController {

    @Inject
    private CoursesUseCases coursesUseCases;

    @GET
    public List<Course> getAllCourses() {
        return coursesUseCases.getAllCourses();
    }

    @GET
    @Path("/{id}")
    public Course getCourseById(@PathParam("id") Integer id) {
        return coursesUseCases.getCourseById(id);
    }

    @GET
    @Path("/faculty/{facultyId}")
    public List<Course> getCoursesByFacultyId(@PathParam("facultyId") Integer facultyId) {
        return coursesUseCases.getCoursesByFacultyId(facultyId);
    }

    @POST
    public void createCourse(Course course) {
        coursesUseCases.createCourse(course);
    }

    @PUT
    public Course updateCourse(Course course) {
        return coursesUseCases.updateCourse(course);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCourse(@PathParam("id") Integer id) {
        coursesUseCases.deleteCourse(id);
    }
}