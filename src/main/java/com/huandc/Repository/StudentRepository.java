package com.huandc.Repository;

import com.huandc.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository {
    List<Student> findALL();

    Optional<Student> findById(String id);

    List<Student> findByIds(List<String> ids);
}
