package mybatis;

import mybatis.dao.CatMapper;
import mybatis.dao.PersonMapper;
import mybatis.dao.PersonMapperAnnotation;
import mybatis.entity.Cat;
import mybatis.entity.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Created by shengchao wu on 6/6/2018.
 */
public class TestMyBatis02 {
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
        CatMapper mapper = sqlSession.getMapper(CatMapper.class);
        Cat cat = new Cat();
        cat.setName("kimi2");
        cat.setBirth(new Date());
        cat.setColor("pink");
        mapper.add(cat);

        System.out.println("cat id : " + cat.getId());
        sqlSession.commit();
    }


    @Test
    public void testQueryByCriteria() {
        CatMapper mapper = sqlSession.getMapper(CatMapper.class);
        Cat cat = new Cat();
        cat.setName("mini");
        cat.setColor("yellow");

        List<Cat> result = mapper.getCatsByConditions(cat);
        result.forEach(System.out::println);
        sqlSession.commit();
    }


    @Test
    public void testQueryByLike() {
        CatMapper mapper = sqlSession.getMapper(CatMapper.class);
        Cat cat = new Cat();
        cat.setName("m%");
        List<Cat> result = mapper.getCatsLikedByName(cat);
        result.forEach(System.out::println);
        sqlSession.commit();
    }

    @Test
    public void testQueryByLike2() {
        CatMapper mapper = sqlSession.getMapper(CatMapper.class);
        List<Cat> result = mapper.getCatsLikedByNameDollar("m");
        result.forEach(System.out::println);
        sqlSession.commit();
    }

    @Test
    public void testQueryByMap() {
        CatMapper mapper = sqlSession.getMapper(CatMapper.class);
        Map<String, Object> criteria = new HashMap<>();
//        criteria.put("name", "m%");
        criteria.put("color", "yellow");
        List<Cat> result = mapper.getCatsByMapsCondition(criteria);
        result.forEach(System.out::println);
        sqlSession.commit();
    }

    @Test
    public void testResultMap() {
        CatMapper mapper = sqlSession.getMapper(CatMapper.class);
        Map<String, Object> criteria = new HashMap<>();
//        criteria.put("name", "m%");
        criteria.put("color", "yellow");
        List<Map<String, Object>> resultMapList = mapper.getResultMap(criteria);
        resultMapList.forEach(map -> map.forEach((key, value) -> {
            System.out.print("key: " + key + "value: " + value);
            System.out.println();
        }));
        sqlSession.commit();
    }



    @After
    public void tearDown() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }




}
