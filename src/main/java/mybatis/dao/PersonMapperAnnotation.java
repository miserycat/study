package mybatis.dao;

import mybatis.entity.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by shengchao wu on 6/5/2018.
 */
public interface PersonMapperAnnotation {
    @Insert("INSERT INTO tbl_person(name,age,birth,registerTime,salary) " +
            "VALUES(#{name},#{age},#{birth},#{registerTime},#{salary})")
    void add(Person person);

    @Delete("delete from tbl_person where id=#{id}")
    void delete(Integer id);

    @Update("update tbl_person set name = #{name}, age = #{age}," +
            "birth = #{birth}, registerTime = #{registerTime}, salary = #{salary}" +
            "where id = #{id}")
    void update(Person person);

    @Select("select * from tbl_person where id = #{id}")
    Person getPersonById(Integer id);

    @Select("select * from tbl_person")
    List<Person> getAllPerson();

}
