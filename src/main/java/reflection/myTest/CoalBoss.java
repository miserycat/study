package reflection.myTest;

/**
 * Created by shengchao wu on 4/25/2018.
 */
public class CoalBoss implements Boss {
    @Override
    public void meet() {
        System.out.println("coalBoss meet...");
    }

    @Override
    public void consume() {
        System.out.println("coalBoss consume...");
    }
}
