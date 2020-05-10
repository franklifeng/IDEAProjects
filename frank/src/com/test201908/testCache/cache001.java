package com.test201908.testCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author frank
 * @create 2019-08-20 9:28
 */
public class cache001<K,V> extends LinkedHashMap<K,V>{
    private  final int CACHE_SIZE;

    public cache001(int cachesize){
        super((int)Math.ceil(cachesize/0.75+1),0.75f,true);
        this.CACHE_SIZE = cachesize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
}
