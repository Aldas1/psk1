package org.example.rest;

import org.example.entities.Faculty;
import org.example.usecases.FacultyUseCases;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/faculties")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacultyController {

    @Inject
    private FacultyUseCases facultyUseCases;

    @GET
    public List<Faculty> getAllFaculties() {
        return facultyUseCases.getAllFaculties();
    }

    @GET
    @Path("/{id}")
    public Faculty getFacultyById(@PathParam("id") Integer id) {
        return facultyUseCases.getFacultyById(id);
    }

    @POST
    public void createFaculty(Faculty faculty) {
        facultyUseCases.createFaculty(faculty);
    }

    @PUT
    public Faculty updateFaculty(Faculty faculty) {
        return facultyUseCases.updateFaculty(faculty);
    }

    @DELETE
    @Path("/{id}")
    public void deleteFaculty(@PathParam("id") Integer id) {
        facultyUseCases.deleteFaculty(id);
    }
}