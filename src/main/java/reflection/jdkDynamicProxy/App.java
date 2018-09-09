package reflection.jdkDynamicProxy;
import org.junit.Test;
/**
 * Created by shengchao wu on 4/25/2018.
 */
public class App {

    @Test
    public void testStaticProxy() {
        CoalBoss coalBoss = new CoalBoss();
        CoalBossProxy coalBossProxy = new CoalBossProxy(coalBoss);
        coalBossProxy.consume();

        SteelBoss steelBoss = new SteelBoss();
        SteelBossProxy steelBossProxy = new SteelBossProxy(steelBoss);
        steelBossProxy.consume();
    }

    @Test
    public void testDynamicProxy() {
//        CoalBoss coalBoss = new CoalBoss();
//
//        DynamicBossProxy proxy = new DynamicBossProxy();
//
//        Boss boss = (Boss) proxy.newBossProxyInstance(coalBoss);
//
//        boss.meet();
//
//        boss.consume();

        Boss boss = new CoalBoss();
        DynamicBossProxy2 bossProxyHandler = new DynamicBossProxy2(boss);
        Boss bossProxy = bossProxyHandler.getBossProxy();
        bossProxy.meet();
    }
}
