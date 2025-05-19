package org.example.persistence.jpa;

import org.example.entities.Faculty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FacultiesDAOJPA {

    @Inject
    private EntityManager em;

    public List<Faculty> findAll() {
        return em.createQuery("SELECT f FROM Faculty f", Faculty.class).getResultList();
    }

    public Faculty findById(Integer id) {
        return em.find(Faculty.class, id);
    }

    @Transactional
    public void persist(Faculty faculty) {
        this.em.persist(faculty);
    }

    @Transactional
    public Faculty update(Faculty faculty) {
        return em.merge(faculty);
    }

    @Transactional
    public void delete(Integer id) {
        Faculty faculty = em.find(Faculty.class, id);
        if (faculty != null) {
            em.remove(faculty);
        }
    }
}