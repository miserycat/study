package Mock;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.mock;

/**
 * Created by shengchao wu on 9/7/2017.
 */


public class SoulTest {

    public void testUseAnswer() {
        Soul soul = mock(Soul.class);
        returnsFirstArg();
    }
}
