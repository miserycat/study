package refactor.ifelse.command;

public class AddCommand implements Command{
    private int first;
    private int second;

    public AddCommand(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Integer execute() {
        return this.first + this.second;
    }
}
