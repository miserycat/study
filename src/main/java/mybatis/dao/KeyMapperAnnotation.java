package mybatis.dao;

import mybatis.entity.Key;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by shengchao wu on 6/8/2018.
 */
public interface KeyMapperAnnotation {

    @Select("select * from tbl_key where id = #{id}")
    @Results({
            @Result( id = true, property = "id", column = "id"),
            @Result( property = "name", column = "keyName")
    })
    Key getKey(Integer id);
}
