package com.fh.utils;


import redis.clients.jedis.Jedis;

public class RedisUtils {

    /**
     * redis 为key赋值方法
     *
     * @param key
     * @param value
     */
    public static void setKey(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getResource( );
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace( );
            throw new RuntimeException(e);
        } finally {
            if (null != jedis) {
                jedis.close( );
            }
        }
    }

    /**
     * redis get取值方法
     *
     * @param key
     */
    public static String getKey(String key) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getResource( );
            String res = jedis.get(key);
            return res;
        } catch (Exception e) {
            e.printStackTrace( );
            throw new RuntimeException(e);
        } finally {
            if (null != jedis) {
                jedis.close( );
            }
        }
    }

    /**
     * redis delet删除方法
     *
     * @param key
     */
    public static void delKey(String key) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getResource( );
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace( );
            throw new RuntimeException(e);
        } finally {
            if (null != jedis) {
                jedis.close( );
            }
        }
    }

    public static void setEx(String key, String value, int expireDate) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getResource( );
            jedis.setex(key, expireDate, value);
        } catch (Exception e) {
            e.printStackTrace( );
        } finally {
            if (null != jedis) {
                jedis.close( );
            }
        }
    }

    /**
     * 判断key 是否存在
     *
     * @param key
     * @return
     */
    public static boolean exist(String key) {
        Jedis jedis = null;
        try {
            jedis = RedisPool.getResource( );
            return jedis.exists(key);
        } catch (Exception e) {
            e.printStackTrace( );
            return false;
        } finally {
            if (null != jedis) {
                jedis.close( );
            }
        }
    }

}
