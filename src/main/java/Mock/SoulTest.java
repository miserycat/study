package Mock;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by shengchao wu on 9/7/2017.
 */


public class SoulTest {

    public void testUseAnswer() {
        Soul soul = mock(Soul.class);
        returnsFirstArg();
    }
}
