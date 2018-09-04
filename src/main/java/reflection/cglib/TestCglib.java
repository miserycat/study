package reflection.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by shengchao wu on 7/9/2018.
 */
public class TestCglib {
    public static void main(String[] args) {

        ShipProxy shipProxy = new ShipProxy();
        ShipProxy2 shipProxy2 = new ShipProxy2();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Ship.class);
        enhancer.setCallbacks(new Callback[]{shipProxy, shipProxy2});
        enhancer.setCallbackFilter(method -> {
            if (method.getName().equals("travel")) {
                return 0;
            } else {
                return 1;
            }

        });
        Ship ship = (Ship) enhancer.create();
        ship.travel();
        ship.fixing();

    }
}
