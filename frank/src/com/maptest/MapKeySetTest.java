package com.maptest;

import javafx.scene.effect.SepiaTone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author frank
 * @create 2019-10-17 9:30
 */
public class MapKeySetTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("A","124");
        map.put("A","124");
        map.put("A","124");
        map.put("A","124");
        map.put("A","124");
        map.put("A","127");
        Set<String> set =  map.keySet();
        for(String k :set){
            System.out.println(k);
        }

        ArrayList a = new ArrayList();

    }


}
