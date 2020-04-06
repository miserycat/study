package refactor.ifelse.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperationFactory {
    static Map<String, Operation> operationMap = new HashMap<>();

    static {
        operationMap.put("add", new AddOperation());
        operationMap.put("subtract", new SubtractOperation());
        operationMap.put("multiply", new MultiplyOperation());
        operationMap.put("divide", new DivideOperation());
    }

    public static Optional<Operation> getOperation(final String operation) {
        return Optional.ofNullable(operationMap.get(operation));
    }
}
