package org.example.usecases;

import org.example.entities.Faculty;
import org.example.services.FacultiesService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FacultyUseCases {

    @Inject
    private FacultiesService facultiesService;

    public List<Faculty> getAllFaculties() {
        return facultiesService.getAllFaculties();
    }

    public Faculty getFacultyById(Integer id) {
        return facultiesService.getFacultyById(id);
    }

    public void createFaculty(Faculty faculty) {
        facultiesService.createFaculty(faculty);
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultiesService.updateFaculty(faculty);
    }

    public void deleteFaculty(Integer id) {
        facultiesService.deleteFaculty(id);
    }
}