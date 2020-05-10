package com.test201908.testCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author frank
 * @create 2019-08-20 10:05
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int  CACHESIZE;

    public LRUCache(int cachesize){
        super((int)Math.ceil(cachesize/0.75+1),0.75f,true);
        this.CACHESIZE = cachesize;
    }

    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size()>CACHESIZE;
    }
}
