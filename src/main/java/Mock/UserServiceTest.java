package Mock;

import multiThreading.exer.Account;
import multiThreading.exer.User;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by shengchao wu on 4/10/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Captor
    private ArgumentCaptor<Account> captor;

    @InjectMocks
    @Spy
    private UserService userService = mock(UserService.class, Mockito.CALLS_REAL_METHODS);


    @Test
    public void generateUserListTest() {
        userService.generateUserList();
        verify(userService).findUser(captor.capture());
        System.out.println(captor.getValue().getBalance());
    }

}
