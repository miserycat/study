package mybatis.dao;

import mybatis.entity.Emp;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by shengchao wu on 6/11/2018.
 */
public interface EmpMapperAnnotation {

    @Select("select * from tbl_emp where id = #{id}")
    @Results({
        @Result(id = true, property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "dept", column = "deptId", one = @One(select = "mybatis.dao.DeptMapperAnnotation.getDeptById"))
    })
    Emp getEmpById(Integer id);

    @Select("select * from tbl_emp where deptId = #{deptId}")
    @Results({
        @Result(id = true, property = "id", column = "id"),
        @Result(property = "name", column = "name")
    })
    List<Emp> getEmpByDeptId(Integer deptId);
}
