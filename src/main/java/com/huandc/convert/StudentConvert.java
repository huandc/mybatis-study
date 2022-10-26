package com.huandc.convert;

import com.huandc.dto.StudentDTO;
import com.huandc.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class StudentConvert {
    public static StudentConvert INSTANT = Mappers.getMapper(StudentConvert.class);

    @Mapping(target = "telephone", source = "tel")
    @Mapping(target = "sex", source = "student", qualifiedByName = "convertToSex")
    public abstract StudentDTO convertDto(Student student);

    @Named("convertToSex")
    public String convertToSex(Student student) {
        return student.getSex() ? "男" : "女";
    }
}
