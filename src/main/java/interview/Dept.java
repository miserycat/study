package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengchao wu on 7/18/2018.
 */
public class Dept {
    private int id;

    private String name;

    //users in the dept
    private List<User> users = new ArrayList<>();


    //child depts
    private List<Dept> depts = new ArrayList<>();

    public Dept() {
    }

    public Dept(int id, String name) {
        this.id = id;
        this.name = name;
    }



    //find user from current dept and the child dept
    public User findUserByUserId(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        for (Dept dept : depts) {
            User user = dept.findUserByUserId(id);
            if (user != null) {
                return user;
            }
        }
        return null;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
