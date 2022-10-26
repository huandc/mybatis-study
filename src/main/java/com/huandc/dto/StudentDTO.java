package com.huandc.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class StudentDTO {
    private Long id;

    String name;

    String sex;

    String telephone;
}
