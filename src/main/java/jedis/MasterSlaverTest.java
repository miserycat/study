package jedis;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by shengchao wu on 4/25/2018.
 */
public class MasterSlaverTest {
    @Test
    public void test() {
        Jedis master = new Jedis("192.168.223.147", 6379);
        Jedis slaver1 = new Jedis("192.168.223.147", 6380);
        Jedis slaver2 = new Jedis("192.168.223.147", 6381);
        master.auth("password");
        slaver1.auth("password");
        slaver2.auth("password");

        slaver1.slaveof("192.168.223.147", 6379);
        slaver2.slaveof("192.168.223.147", 6379);
        slaver2.slaveofNoOne();
        master.close();

    }
}
