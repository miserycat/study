package refactor.ifelse.ruleEngine;

public class Expression {
    private Integer x;
    private Integer y;
    private Operator operator;

    public Expression(Integer x, Integer y, Operator operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
