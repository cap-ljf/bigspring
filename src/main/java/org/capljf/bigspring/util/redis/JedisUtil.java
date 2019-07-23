package org.capljf.bigspring.util.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.time.Duration;

/**
 * @author jifang.liu created on 2019/6/18 16:58
 */
@Slf4j
public class JedisUtil {

    private static final JedisPool JEDIS_POOL;

    static {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);
        JEDIS_POOL = new JedisPool(poolConfig, "10.93.153.143");
    }

    public static String get(String key){
        try {
            return JEDIS_POOL.getResource().get(key);
        } catch (Exception e){
            log.error("jedis get method error. param:{}", key, e);
        }
        return null;
    }



    public static void main(String[] args) {
        try (Jedis jedis = JEDIS_POOL.getResource()) {
            String foo = jedis.get("foo");
            System.out.println(foo);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JEDIS_POOL.destroy();
        }

        try (JedisCluster jedisCluster = new JedisCluster(new HostAndPort("10.93.153.143", 6379))){
            String foo = jedisCluster.get("foo");
            System.out.println(foo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
