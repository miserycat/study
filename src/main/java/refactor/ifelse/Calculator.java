package refactor.ifelse;

import refactor.ifelse.command.AddCommand;
import refactor.ifelse.command.Command;
import refactor.ifelse.enumRefactor.Operator;
import refactor.ifelse.factory.Operation;
import refactor.ifelse.factory.OperationFactory;
import refactor.ifelse.ruleEngine.Expression;
import refactor.ifelse.ruleEngine.Result;
import refactor.ifelse.ruleEngine.RuleEngine;

public class Calculator {
    public static void main(String[] args) {
        int result = Operator.ADD.apply(10, 20);

        System.out.println(result);


        result = calculateCommand(new AddCommand(1, 2));

        System.out.println(result);

        result = calculateRuleEngine(new Expression(2, 3, refactor.ifelse.ruleEngine.Operator.ADD));

        System.out.println(result);


    }


    public static int calculate(int a, int b, String operation) {
        if ("add".equals(operation)) {
            return a + b;
        } else if ("subtract".equals(operation)) {
            return a - b;
        } else if ("multiply".equals(operation)) {
            return a * b;
        } else if ("divide".equals(operation)) {
            return a / b;
        }

        throw new IllegalArgumentException("not supported operator" + operation);
    }


    public static int calculateSwitch(int a, int b, String operation) {
        switch (operation) {
            case "add" : {
                return a + b;
            }
            case "subtract" : {
                return a - b;
            }
            case "multiply" : {
                return a * b;
            }
            case "divide" : {
                return a / b;
            }
        }

        throw new IllegalArgumentException("not supported operator" + operation);
    }

    public static int calculateFactory(int a, int b, String operation) {
        Operation op = OperationFactory.getOperation(operation)
                .orElseThrow(() -> new IllegalArgumentException("not supported operation" + operation));

        return op.apply(a, b);
    }

    public static int calculateCommand(Command command) {
        return command.execute();
    }

    public static int calculateRuleEngine(Expression expression) {
        RuleEngine ruleEngine = new RuleEngine();
        Result result = ruleEngine.process(expression);

        return result.getValue();
    }


}