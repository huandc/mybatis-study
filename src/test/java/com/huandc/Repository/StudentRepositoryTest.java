package com.huandc.Repository;

import com.huandc.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    void should_find_all() {
        var students = studentRepository.findALL();
        assertEquals(6, students.size());
        assertEquals(1,students.get(0).getId());
        assertEquals("huan", students.get(0).getName());
        assertEquals("lisi",students.get(4).getName());
    }

    @Test
    void should_find_by_id() {
        var student = studentRepository.findById("1");
        assertTrue(student.isPresent());
        assertEquals("huan", student.get().getName());
    }

    @Test
    void should_find_by_ids() {
        List<String> ids = List.of("1", "2");
        var students = studentRepository.findByIds(ids);
        assertEquals(2, students.size());
        assertEquals("huan", students.get(0).getName());
        assertEquals("chong",students.get(1).getName());
    }
}