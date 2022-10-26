package com.huandc;

import com.huandc.convert.StudentConvert;
import com.huandc.model.Student;
import org.junit.jupiter.api.Test;

public class StudentConvertTest {

    @Test
    public void testConvert(){
        var student = Student.builder()
                .id(1L)
                .name("name")
                .sex(true)
                .tel("15276834526")
                .build();

        var studentDTO = StudentConvert.INSTANT.convertDto(student);

        System.out.println(studentDTO);

    }
}
