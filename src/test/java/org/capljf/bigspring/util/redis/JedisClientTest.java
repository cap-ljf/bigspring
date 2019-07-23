package org.capljf.bigspring.util.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author jifang.liu created on 2019/6/18 10:37
 */
public class JedisClientTest {

    private static JedisPool pool = new JedisPool(new JedisPoolConfig(), "10.93.153.143");

    @Test
    public void getJedisClient(){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.set("msg", "hello world");
            String foo = jedis.get("msg");
            System.out.println(foo);
        } finally {
            if (jedis != null){
                jedis.close();
            }
        }
        pool.destroy();
    }

}
