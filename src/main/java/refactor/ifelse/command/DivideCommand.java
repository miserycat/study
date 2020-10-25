package refactor.ifelse.command;

public class DivideCommand implements Command{
    private int first;
    private int second;

    public DivideCommand(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Integer execute() {
        return this.first / this.second;
    }
}
