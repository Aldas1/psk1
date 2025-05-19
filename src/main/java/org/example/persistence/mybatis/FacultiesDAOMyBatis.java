package org.example.persistence.mybatis;

import org.example.mybatis.model.Faculty;
import org.mybatis.cdi.Mapper;

import jakarta.transaction.Transactional;
import java.util.List;

@Mapper
public interface FacultiesDAOMyBatis {

    List<Faculty> selectAll();

    Faculty selectById(Integer id);

    @Transactional
    void insert(Faculty faculty);

    @Transactional
    void update(Faculty faculty);

    @Transactional
    void delete(Integer id);
}