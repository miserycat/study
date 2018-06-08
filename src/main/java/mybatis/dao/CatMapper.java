package mybatis.dao;

import mybatis.entity.Cat;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by shengchao wu on 6/6/2018.
 */
public interface CatMapper {

    void add(Cat cat);

    List<Cat> getCatsByConditions(Cat cat);

    List<Cat> getCatsLikedByName(Cat cat);

    List<Cat> getCatsLikedByNameDollar(@Param(value = "name") String catName);

    List<Cat> getCatsByMapsCondition(Map<String, Object> criteria);

    List<Map<String, Object>> getResultMap(Map<String, Object> criteria);


}
