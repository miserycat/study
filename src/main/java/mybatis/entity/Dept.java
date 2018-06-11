package mybatis.entity;

import java.util.List;

/**
 * Created by shengchao wu on 6/11/2018.
 */
public class Dept {
    private Integer id;

    private String deptName;

    private String locAdd;

    private List<Emp> emps;

    public Dept() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocAdd() {
        return locAdd;
    }

    public void setLocAdd(String locAdd) {
        this.locAdd = locAdd;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", locAdd='" + locAdd + '\'' +
                ", emps=" + emps +
                '}';
    }
}
