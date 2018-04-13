package Mock;

import multiThreading.exer.Account;
import multiThreading.exer.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shengchao wu on 4/10/2018.
 */
public class UserService implements UserServiceLocal{

    @Override
    public List<User> generateUserList() {
        Account account = new Account();
        account.setBalance(10000);
        User user = new User(account);
        return Arrays.asList(user);
    }
}
