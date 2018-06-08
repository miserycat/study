package mybatis;

import mybatis.dao.DogMapper;
import mybatis.entity.Dog;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by shengchao wu on 6/6/2018.
 */
public class TestMyBatis03 {
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    @Before
    public void setUp() {
        InputStream configResource = this.getClass().getClassLoader().getResourceAsStream("myba;tis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configResource);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testInsert() {
        DogMapper mapper = sqlSession.getMapper(DogMapper.class);
        Dog dog = new Dog();
        dog.setName("wangcai");
        dog.setAge(10);
        mapper.add(dog);
        System.out.println("dog id : " + dog.getId());
        sqlSession.commit();
    }


    @Test
    public void testQueryByCriteria() {
        DogMapper mapper = sqlSession.getMapper(DogMapper.class);
        Dog dog = new Dog();
        dog.setName("wangcai");
        dog.setAge(10);
        List<Dog> result = mapper.getDogsByConditions(dog);
        result.forEach(System.out::println);
        sqlSession.commit();
    }




    @After
    public void tearDown() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }




}
