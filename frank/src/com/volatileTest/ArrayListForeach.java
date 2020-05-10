package com.volatileTest;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author frank
 * @create 2019-07-29 16:22
 */
public class ArrayListForeach {
//    List<String> list = Arrays.asList("a","b","c","d");
    List<String> list = Arrays.asList("a","b");


/*    List<String> list = Collections.synchronizedList(new ArrayList<>());
    List list01 = new Vector();*/
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a","b","c","d");
/*        list.forEach(System.out::println);
        list.stream().forEach(System.out::println);*/

//        List<String> list = Collections.synchronizedList(new ArrayList<>());

        List<String> list = new CopyOnWriteArrayList<>();
//        List<String> list = new Vector<>();
        list.add("s");

        for(int i=0;i<30;i++){
           new Thread(()->{
               list.add(UUID.randomUUID().toString().substring(0,8));
               System.out.println(list);
           }, String.valueOf(i)).start();
        }
    }
}
