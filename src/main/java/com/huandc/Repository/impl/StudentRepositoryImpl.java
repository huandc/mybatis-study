package com.huandc.Repository.impl;

import com.huandc.Repository.StudentRepository;
import com.huandc.Repository.mapper.StudentMapper;
import com.huandc.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> findALL() {
        return studentMapper.findAll();
    }

    @Override
    public Optional<Student> findById(String id) {
        return studentMapper.findById(id);
    }

    @Override
    public List<Student> findByIds(List<String> ids) {
        return studentMapper.findByIds(ids);
    }
}
