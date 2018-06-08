package reflection.myTest;
/**
 * Created by shengchao wu on 4/25/2018.
 */
public class SteelBossProxy implements Boss{
    private SteelBoss steelBoss;

    public SteelBossProxy(SteelBoss steelBoss) {
        this.steelBoss = steelBoss;
    }


    @Override
    public void meet() {
        System.out.println("post meet steel boss...");
        steelBoss.meet();
        System.out.println("meet finish");
    }

    @Override
    public void consume() {
        System.out.println("post consume steel boss..");
        steelBoss.consume();
        System.out.println("consume finish");
    }
}
