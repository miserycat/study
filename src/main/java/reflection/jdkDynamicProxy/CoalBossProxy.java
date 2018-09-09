package reflection.jdkDynamicProxy;

/**
 * Created by shengchao wu on 4/25/2018.
 */
public class CoalBossProxy implements Boss{
    private CoalBoss coalBoss;

    public CoalBossProxy(CoalBoss coalBoss) {
        this.coalBoss = coalBoss;
    }


    @Override
    public void meet() {
        System.out.println("do meet post job...");
        coalBoss.meet();
        System.out.println("meet finish...");
    }

    @Override
    public void consume() {
        System.out.println("do consume post job...");
        coalBoss.consume();
        System.out.println("consume finish...");
    }
}
