package org.example.persistence.jpa;

import org.example.entities.Student;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class StudentsDAOJPA {

    @Inject
    private EntityManager em;

    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }

    public List<Student> findByFacultyId(Integer facultyId) {
        return em.createQuery("SELECT s FROM Student s WHERE s.faculty.id = :facultyId", Student.class)
                .setParameter("facultyId", facultyId)
                .getResultList();
    }

    @Transactional
    public void persist(Student student) {
        this.em.persist(student);
    }

    @Transactional
    public Student update(Student student) {
        return em.merge(student);
    }

    @Transactional
    public void delete(Integer id) {
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
    }
}