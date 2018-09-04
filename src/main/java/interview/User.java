package interview;

/**
 * Created by shengchao wu on 7/18/2018.
 */
public class User {
    private int id;

    private String name;

    private Dept dept;

    public User() {
    }

    public User(int id, String name, Dept dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
