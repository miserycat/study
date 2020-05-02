package Mock;

import multiThreading.exer.Account;
import multiThreading.exer.User;

import java.util.List;

/**
 * Created by shengchao wu on 4/10/2018.
 */
public interface UserServiceLocal {

    List<User> generateUserList();

    User findUser(Account account);

}
