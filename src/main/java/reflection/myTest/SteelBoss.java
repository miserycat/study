package reflection.myTest;

/**
 * Created by shengchao wu on 4/25/2018.
 */
public class SteelBoss implements Boss {
    @Override
    public void meet() {
        System.out.println("steelBoss meet...");
    }

    @Override
    public void consume() {
        System.out.println("steelBoss consume...");
    }
}
