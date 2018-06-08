package mybatis.dao;

import mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by shengchao wu on 6/6/2018.
 */
public interface StudentMapper {

    void add(Student student);

    void update(Student student);

    List<Student> getStudentsByAge(Student student);

    List<Student> getStudentsByAgeIf(@Param("age") int age);

    List<Student> getStudentsWhere(Student student);

    List<Student> getStudentsChoose(Student student);

    List<Student> getStudentsForEach(Map<String, Object> map);

    List<Student> getStudentsTrim(Map<String, Object> map);

    void insertStudentsTrim(Student student);


}
