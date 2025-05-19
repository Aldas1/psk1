package org.example.persistence.mybatis;

import org.example.mybatis.model.Student;
import org.mybatis.cdi.Mapper;

import java.util.List;
import jakarta.transaction.Transactional;

@Mapper
public interface StudentsDAOMyBatis {

    List<Student> selectAll();

    Student selectById(Integer id);

    List<Student> selectByFacultyId(Integer facultyId);

    @Transactional
    void insert(Student student);

    @Transactional
    void update(Student student);

    @Transactional
    void delete(Integer id);

    // Metodai many-to-many ryšių valdymui
    @Transactional
    void insertStudentCourse(Integer studentId, Integer courseId);

    @Transactional
    void deleteStudentCourse(Integer studentId, Integer courseId);

    List<Student> selectByCourseId(Integer courseId);
}