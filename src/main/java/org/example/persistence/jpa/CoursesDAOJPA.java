package org.example.persistence.jpa;

import org.example.entities.Course;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CoursesDAOJPA {

    @Inject
    private EntityManager em;

    public List<Course> findAll() {
        return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    public Course findById(Integer id) {
        return em.find(Course.class, id);
    }

    public List<Course> findByFacultyId(Integer facultyId) {
        return em.createQuery("SELECT c FROM Course c WHERE c.faculty.id = :facultyId", Course.class)
                .setParameter("facultyId", facultyId)
                .getResultList();
    }

    @Transactional
    public void persist(Course course) {
        this.em.persist(course);
    }

    @Transactional
    public Course update(Course course) {
        return em.merge(course);
    }

    @Transactional
    public void delete(Integer id) {
        Course course = em.find(Course.class, id);
        if (course != null) {
            em.remove(course);
        }
    }
}