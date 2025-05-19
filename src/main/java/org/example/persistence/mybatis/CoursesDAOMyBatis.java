package org.example.persistence.mybatis;

import org.example.mybatis.model.Course;
import org.mybatis.cdi.Mapper;

import jakarta.transaction.Transactional;
import java.util.List;

@Mapper
public interface CoursesDAOMyBatis {

    List<Course> selectAll();

    Course selectById(Integer id);

    List<Course> selectByFacultyId(Integer facultyId);

    @Transactional
    void insert(Course course);

    @Transactional
    void update(Course course);

    @Transactional
    void delete(Integer id);

    // Metodai many-to-many ryšių valdymui
    List<Course> selectByStudentId(Integer studentId);
}