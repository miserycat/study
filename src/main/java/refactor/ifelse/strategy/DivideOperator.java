package refactor.ifelse.strategy;

public class DivideOperator implements Operator {
    @Override
    public int calculate(int x, int y) {
        return x / y;
    }

    @Override
    public String getType() {
        return "divide";
    }


}
