package mybatis.dao;

import mybatis.entity.Dept;

/**
 * Created by shengchao wu on 6/11/2018.
 */
public interface DeptMapper {
    Dept getDeptById(Integer id);
}
