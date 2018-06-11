package mybatis.dao;

import mybatis.entity.Emp;

import java.util.List;

/**
 * Created by shengchao wu on 6/11/2018.
 */
public interface EmpMapper {
    List<Emp> getEmpByDeptId(Integer id);

    Emp getEmpById(Integer id);
}
