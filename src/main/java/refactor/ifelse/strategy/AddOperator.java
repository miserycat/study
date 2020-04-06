package refactor.ifelse.strategy;

public class AddOperator implements Operator {
    @Override
    public int calculate(int x, int y) {
        return x + y;
    }

    @Override
    public String getType() {
        return "add";
    }


}
