package mybatis.dao;

import mybatis.entity.Lock;

/**
 * Created by shengchao wu on 6/8/2018.
 */
public interface LockMapper {
    Lock getLock(Integer id);
}
