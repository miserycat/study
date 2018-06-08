package reflection.myTest;

import java.lang.reflect.Proxy;

/**
 * Created by shengchao wu on 5/7/2018.
 */
public class DynamicBossProxy2 {

    private Boss target;

    public DynamicBossProxy2(Boss target) {
        this.target = target;
    }

    public Boss getBossProxy() {
        Boss bossProxy = (Boss) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("meet before...");
                    Object result = method.invoke(target, args);
                    System.out.println("meet after...");
                    return result;

                });
        return bossProxy;
    }
}
