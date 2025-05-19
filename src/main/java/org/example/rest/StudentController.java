package org.example.rest;

import org.example.entities.Student;
import org.example.usecases.StudentsUseCases;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {

    @Inject
    private StudentsUseCases studentsUseCases;

    @GET
    public List<Student> getAllStudents() {
        return studentsUseCases.getAllStudents();
    }

    @GET
    @Path("/{id}")
    public Student getStudentById(@PathParam("id") Integer id) {
        return studentsUseCases.getStudentById(id);
    }

    @GET
    @Path("/faculty/{facultyId}")
    public List<Student> getStudentsByFacultyId(@PathParam("facultyId") Integer facultyId) {
        return studentsUseCases.getStudentsByFacultyId(facultyId);
    }

    @POST
    public void createStudent(Student student) {
        studentsUseCases.createStudent(student);
    }

    @PUT
    public Student updateStudent(Student student) {
        return studentsUseCases.updateStudent(student);
    }

    @DELETE
    @Path("/{id}")
    public void deleteStudent(@PathParam("id") Integer id) {
        studentsUseCases.deleteStudent(id);
    }

    @POST
    @Path("/{studentId}/courses/{courseId}")
    public void registerStudentForCourse(@PathParam("studentId") Integer studentId, @PathParam("courseId") Integer courseId) {
        studentsUseCases.registerStudentForCourse(studentId, courseId);
    }

    @DELETE
    @Path("/{studentId}/courses/{courseId}")
    public void unregisterStudentFromCourse(@PathParam("studentId") Integer studentId, @PathParam("courseId") Integer courseId) {
        studentsUseCases.unregisterStudentFromCourse(studentId, courseId);
    }
}