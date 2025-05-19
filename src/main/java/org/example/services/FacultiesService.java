package org.example.services;

import org.example.entities.Faculty;
import org.example.persistence.jpa.FacultiesDAOJPA;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FacultiesService {

    @Inject
    private FacultiesDAOJPA facultiesDAO;

    public List<Faculty> getAllFaculties() {
        return facultiesDAO.findAll();
    }

    public Faculty getFacultyById(Integer id) {
        return facultiesDAO.findById(id);
    }

    @Transactional
    public void createFaculty(Faculty faculty) {
        facultiesDAO.persist(faculty);
    }

    @Transactional
    public Faculty updateFaculty(Faculty faculty) {
        return facultiesDAO.update(faculty);
    }

    @Transactional
    public void deleteFaculty(Integer id) {
        facultiesDAO.delete(id);
    }
}