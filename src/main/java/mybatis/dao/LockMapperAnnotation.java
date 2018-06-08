package mybatis.dao;

import mybatis.entity.Lock;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by shengchao wu on 6/8/2018.
 */
public interface LockMapperAnnotation {

    @Select("select * from tbl_lock where id = #{id}")
    @Results({
            @Result( id = true, property = "id", column = "id"),
            @Result( property = "name", column = "lockName"),
            @Result( property = "key", column = "key_id", one = @One(select = "mybatis.dao.KeyMapperAnnotation.getKey"))
    })
    Lock getLock(Integer id);
}
