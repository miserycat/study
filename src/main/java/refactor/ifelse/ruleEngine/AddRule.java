package refactor.ifelse.ruleEngine;

public class AddRule implements Rule{
    private Result result;
    @Override
    public boolean evaluate(Expression expression) {
        if (!expression.getOperator().equals(Operator.ADD)) {
            return false;
        }
        result = new Result();
        result.setValue(expression.getX() + expression.getY());
        return true;
    }

    @Override
    public Result getResult() {
        return result;
    }

}
