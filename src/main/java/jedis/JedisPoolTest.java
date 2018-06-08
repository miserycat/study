package jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by shengchao wu on 4/25/2018.
 */
public class JedisPoolTest {

    @Test
    public void test() {
        JedisPool jedisPool = JedisPoolUtils.getJedisPoolInstance();

        Jedis jedis = jedisPool.getResource();



    }
}
