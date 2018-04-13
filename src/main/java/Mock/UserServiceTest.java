package Mock;

import multiThreading.exer.User;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Test;
/**
 * Created by shengchao wu on 4/10/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private ArgumentCaptor<User> captor;

    @Test
    public void generateUserListTest() {

    }

}
