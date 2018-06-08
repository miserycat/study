package mybatis;

import mybatis.dao.PersonMapper;
import mybatis.dao.PersonMapperAnnotation;
import mybatis.entity.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Created by shengchao wu on 6/6/2018.
 */
public class TestMyBatis01 {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() {
        InputStream configResource = this.getClass().getClassLoader().getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configResource);

    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        person.setName("tracy");
        person.setBirth(new Date());
        person.setSalary(20000);
        person.setAge(25);
        mapper.add(person);
        sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.getPersonById(2);
        assertThat(person.getAge(), is(25));
        System.out.println(person);
        person.setAge(50);
        mapper.update(person);
        person = mapper.getPersonById(2);
        sqlSession.commit();
        assertThat(person.getAge(), is(50));
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        mapper.delete(2);
        Person person = mapper.getPersonById(2);
        sqlSession.commit();
        assertThat(person, nullValue());
    }

    @Test
    public void testFindAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> personList = mapper.getAllPerson();
        sqlSession.commit();
        personList.forEach(System.out::println);
    }

    @Test
    public void testNativeAPI() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Person person = new Person();
        person.setName("moon");
        person.setBirth(new Date());
        person.setSalary(8000);
        person.setAge(35);
        sqlSession.insert("mybatis.dao.PersonMapper.add", person);
        sqlSession.delete("mybatis.dao.PersonMapper.delete", 3);
        List<Object> personList = sqlSession.selectList("mybatis.dao.PersonMapper.getAllPerson", Person.class);
        sqlSession.commit();
        personList.forEach(System.out::println);
    }

    @Test
    public void testAnnotation() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapperAnnotation mapper = sqlSession.getMapper(PersonMapperAnnotation.class);
        List<Person> personList = mapper.getAllPerson();
        personList.forEach(System.out::println);
        sqlSession.commit();
        assertThat(personList.size(), is(3));
    }

}
