package mybatis.dao;

import mybatis.entity.Dept;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * Created by shengchao wu on 6/11/2018.
 */
public interface DeptMapperAnnotation {

    @Select("select * from tbl_dept where id = #{id}")
    @Results({
        @Result(id = true, property = "id", column = "id"),
        @Result(property = "deptName", column = "deptName"),
        @Result(property = "locAdd", column = "locAdd"),
        @Result(property = "emps", column = "id", many = @Many(select = "mybatis.dao.EmpMapperAnnotation.getEmpByDeptId", fetchType = FetchType.LAZY))
    })
    Dept getDeptById(Integer id);

}
