package mybatis;

import mybatis.dao.LockMapper;
import mybatis.dao.LockMapperAnnotation;
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
import java.util.concurrent.locks.Lock;

/**
 * Created by shengchao wu on 6/6/2018.
 */
public class TestMyBatis05 {
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    @Before
    public void setUp() {
        InputStream configResource = this.getClass().getClassLoader().getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configResource);
        sqlSession = sqlSessionFactory.openSession();
    }


    @Test
    public void testGetLock() {
        LockMapper mapper = sqlSession.getMapper(LockMapper.class);
        mybatis.entity.Lock lock = mapper.getLock(1);
        sqlSession.commit();
        System.out.println(lock.getName());
//        System.out.println(lock.getKey().getName());
    }


    @Test
    public void testGetLockAnnotation() {
        LockMapperAnnotation mapper = sqlSession.getMapper(LockMapperAnnotation.class);
        mybatis.entity.Lock lock = mapper.getLock(1);
        sqlSession.commit();
        System.out.println(lock.getName());
        System.out.println(lock.getKey().getName());
    }


    @After
    public void tearDown() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
