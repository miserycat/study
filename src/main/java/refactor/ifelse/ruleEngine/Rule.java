package refactor.ifelse.ruleEngine;

public interface Rule {
    boolean evaluate(Expression expression);

    Result getResult();
}
