package mybatis;

import mybatis.dao.DeptMapper;
import mybatis.dao.DeptMapperAnnotation;
import mybatis.dao.EmpMapper;
import mybatis.dao.EmpMapperAnnotation;
import mybatis.dao.LockMapper;
import mybatis.dao.LockMapperAnnotation;
import mybatis.dao.UserMapper;
import mybatis.entity.Dept;
import mybatis.entity.Emp;
import mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shengchao wu on 6/6/2018.
 */
public class TestMyBatis06 {
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    @Before
    public void setUp() {
        InputStream configResource = this.getClass().getClassLoader().getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configResource);
        sqlSession = sqlSessionFactory.openSession();
    }


    @Test
    public void testGetDeptById() {
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptById(1);
        System.out.println(dept.getDeptName());
//        dept.getEmps().forEach(System.out::print);
    }

    @Test
    public void testGetEmpById() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById(1);
        System.out.println(emp.getName());
        System.out.println(emp.getDept().getDeptName());
    }

    @Test
    public void testGetDeptByIdAnnotation() {
        DeptMapperAnnotation mapper = sqlSession.getMapper(DeptMapperAnnotation.class);
        Dept dept = mapper.getDeptById(2);
        System.out.println(dept.getDeptName());
        dept.getEmps().stream().map(emp -> emp.getName()).forEach(System.out::print);
    }

    @Test
    public void testGetEmpByIdAnnotation() {
        EmpMapperAnnotation mapper = sqlSession.getMapper(EmpMapperAnnotation.class);
        Emp emp = mapper.getEmpById(2);
        System.out.println(emp.getName());
        System.out.println(emp.getDept().getDeptName());
    }


    @Test
    public void testSqlSessionCache() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.getUserById(1);
        System.out.println(user1);

//        User updateUser = new User();
//        updateUser.setId(user1.getId());
//        updateUser.setName("cassie");
//        updateUser.setAge(user1.getAge());
//        mapper.updateUser(updateUser);
        //test sqlSession cache
//        sqlSession.close();
//        sqlSession = sqlSessionFactory.openSession();
//        mapper = sqlSession.getMapper(UserMapper.class);

//        sqlSession.clearCache();
        User user2 = mapper.getUserById(1);
        System.out.println(user2);
    }


    @Test
    public void testUpdate() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setName("cassie");
        user.setAge(34);
        mapper.updateUser(user);
    }


    @Test
    public void testLevel2Cache() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.getUserById(1);
        System.out.println(user2);

        sqlSession2.close();
    }


    @After
    public void tearDown() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
