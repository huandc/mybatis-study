package com.huandc.Repository.mapper;

import com.huandc.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StudentMapper {
    @SelectProvider(method = "findAll", type = StudentMapper.SelectProviderSql.class)
    List<Student> findAll();

    @SelectProvider(method = "findById", type = StudentMapper.SelectProviderSql.class)
    Optional<Student> findById(@Param("id") String id);

    @SelectProvider(method = "findByIds", type = StudentMapper.SelectProviderSql.class)
    List<Student> findByIds(@Param("ids") List<String> ids);


    class SelectProviderSql {
        public static String findAll() {
            SQL sql = new SQL();
            sql.SELECT("*");
            sql.FROM("students");
            return "<script>" + sql + "</script>";
        }

        public static String findById(String id) {
            return new SQL() {{
                SELECT("id", "name");
                FROM("students");
                if (!StringUtils.isEmpty(id)) {
                    WHERE("id = #{id, javaType=String, jdbcType=VARCHAR}");
                }
            }}.toString();
        }

        public static String findByIds(List<String> ids) {
            return new SQL() {
                {
                    SELECT("id", "name");
                    FROM("students");
                    if (!CollectionUtils.isEmpty(ids)) {
                        WHERE("id in (" + String.join(",", ids) + ")");
                    }
                }
            }.toString();
        }
    }
}
