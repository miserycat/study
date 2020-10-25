package refactor.ifelse.factory;

public class DivideOperation implements Operation {
    @Override
    public int apply(int a, int b) {
        return a / b;
    }
}
