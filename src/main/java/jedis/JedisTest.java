package jedis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.Before;
import redis.clients.jedis.Transaction;

/**
 * Created by shengchao wu on 4/24/2018.
 */
public class JedisTest {

    private Jedis jedis;

    @Before
    public void setUp() {
        jedis = new Jedis("192.168.223.147" , 6381);
        jedis.auth("password");
        jedis.flushDB();
    }


    @Test
    public void testString() {
        System.out.println(jedis.ping());

        jedis.set("s1", "100");
        jedis.set("s2", "200");
        jedis.set("s3", "300");
        jedis.set("s4", "400");

        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        jedis.incr("s1");
        System.out.println(jedis.get("s1"));
    }


    @Test
    public void testList() {
        jedis.lpush("list1", "v1", "v2", "v3", "v4");
        List<String> list1 = jedis.lrange("list1", 0, -1);
        System.out.println(list1);

        jedis.lpop("list1");
        list1 = jedis.lrange("list1", 0, -1);
        System.out.println(list1);
        jedis.lpop("list1");
        list1 = jedis.lrange("list1", 0, -1);
        System.out.println(list1);

        jedis.del("list1");
        jedis.rpush("list1", "v1", "v2", "v3", "v4");
        list1 = jedis.lrange("list1", 0, -1);
        System.out.println(list1);
    }

    @Test
    public void testSet() {
        jedis.sadd("set1", "v1", "v2", "v3", "v4");
        Set<String> set1 = jedis.smembers("set1");
        set1.forEach(System.out::println);
        System.out.println(jedis.scard("set1"));

    }

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("s1", "v1");
        map.put("s2", "v2");
        map.put("s3", "v3");
        map.put("s4", "v4");
        map.put("s5", "v5");
        jedis.hmset("map1", map);

        System.out.println(jedis.hgetAll("map1"));
    }

    @Test
    public void testZset() {
        Map<String, Double> map = new HashMap<>();
        map.put("v1", 20d);
        map.put("v2", 40d);
        map.put("v3", 60d);
        map.put("v4", 80d);
        map.put("v5", 100d);
        jedis.zadd("zset1", map);

        System.out.println(jedis.zrangeWithScores("zset1", 0, -1));
        System.out.println(jedis.zrangeByScore("zset1", 60, 90));
    }

    @Test
    public void testTransaction() {
        jedis.set("k1", "100");

        jedis.watch("k1");
        jedis.set("k1", "200");

        Transaction transaction = jedis.multi();
        transaction.set("k1", "999");
        System.out.println(transaction.get("k1"));
        transaction.exec();

        System.out.println(jedis.get("k1"));
    }



}
