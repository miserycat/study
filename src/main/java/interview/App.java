package interview;

import java.util.Arrays;

/**
 * Created by shengchao wu on 7/18/2018.
 */
public class App {
    public static void main(String[] args) {
        Dept dept = new Dept(1, "Management");
        dept.setUsers(Arrays.asList(new User(1, "jack", dept), new User(2, "jane", dept)));
        dept.setDepts(Arrays.asList(new Dept(2, "HR"), new Dept(3, "Dev")));
        dept.getDepts().get(0).setUsers(Arrays.asList(new User(3, "peter", dept.getDepts().get(0)), new User(4, "kevin", dept.getDepts().get(0))));
        dept.getDepts().get(1).setUsers(Arrays.asList(new User(5, "marry", dept.getDepts().get(1)), new User(4, "cassie", dept.getDepts().get(1))));


        User user = dept.findUserByUserId(4);

        System.out.println(user);
    }
}
