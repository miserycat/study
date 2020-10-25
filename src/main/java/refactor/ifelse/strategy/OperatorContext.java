package refactor.ifelse.strategy;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class OperatorContext {

    private Operator operator;

    public int calculate(int x, int y) {
        return operator.calculate(x, y);
    }


}
