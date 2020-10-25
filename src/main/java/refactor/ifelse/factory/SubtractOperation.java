package refactor.ifelse.factory;

public class SubtractOperation implements Operation {
    @Override
    public int apply(int a, int b) {
        return a - b;
    }
}
