package mybatis;

import mybatis.dao.StudentMapper;
import mybatis.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shengchao wu on 6/6/2018.
 */
public class TestMyBatis04 {
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    @Before
    public void setUp() {
        InputStream configResource = this.getClass().getClassLoader().getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configResource);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testInsert() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("wangwu");
        student.setAge(24);
        mapper.add(student);
        System.out.println(student);
        sqlSession.commit();
    }


    @Test
    public void testFindByAge() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setAge(25);
        List<Student> result = mapper.getStudentsByAge(student);
        result.forEach(System.out::println);
        sqlSession.commit();
    }


    @Test
    public void testFindByAgeIf() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> result = mapper.getStudentsByAgeIf(0);
        result.forEach(System.out::println);
        sqlSession.commit();
    }
    @Test
    public void testFindByWhere() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
//        student.setName("zhangsan");
//        student.setAge(25);
        List<Student> result = mapper.getStudentsWhere(student);
        result.forEach(System.out::println);
        sqlSession.commit();
    }

    @Test
    public void testFindByChoose() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("zhangsan");
//        student.setAge(25);
        List<Student> result = mapper.getStudentsChoose(student);
        result.forEach(System.out::println);
        sqlSession.commit();
    }

    @Test
    public void testFindByForeach() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> maps = new HashMap<>();
        maps.put("ages", Arrays.asList(24,23,22));
        List<Student> result = mapper.getStudentsForEach(maps);
        result.forEach(System.out::println);
        sqlSession.commit();
    }
    @Test
    public void testFindByTrim() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> maps = new HashMap<>();
        maps.put("age", 24);
        List<Student> result = mapper.getStudentsTrim(maps);
        result.forEach(System.out::println);
        sqlSession.commit();
    }

    @Test
    public void testInsertTrim() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("cassie");
        student.setAge(34);
        mapper.insertStudentsTrim(student);
        System.out.println(student);
    }


    @Test
    public void testUpdate() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setId(3);
        student.setName("cassie2");
//        student.setAge(34);
        mapper.update(student);
        sqlSession.commit();
        System.out.println(student);
    }



    @After
    public void tearDown() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
