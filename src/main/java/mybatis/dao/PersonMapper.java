package mybatis.dao;

import mybatis.entity.Person;

import java.util.List;

/**
 * Created by shengchao wu on 6/5/2018.
 */
public interface PersonMapper {

    void add(Person person);

    void delete(Integer id);

    void update(Person person);

    Person getPersonById(Integer id);

    List<Person> getAllPerson();

}
