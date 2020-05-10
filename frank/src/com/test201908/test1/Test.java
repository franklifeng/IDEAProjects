package com.test201908.test1;

/**
 * @author frank
 * @create 2020-01-29 12:44
 */
public class Test {
    public String name = "000";
    public Test(String id){
        name = id;
    }

    public static void main(String[] args) {
/*        Test t =  new Test("123");
        System.out.println(t.name);

        System.out.println(3<<2);*/
        char[] chars = {'a','a','b','b','c','c','c'};
        test1(chars);
    }


    public static int  test1(char[] chars){
        int left = 0;
        int size = 0;

        // 由于最后一个字符也需要判断，所以将右指针终点放到数组之外一格
        for (int right = 0; right <= chars.length; right++) {
            // 当遍历完成，或右指针元素不等于左指针元素时，更新数组
            if (right == chars.length || chars[right] != chars[left]) {
                chars[size++] = chars[left];    // 更新字符
                if (right - left > 1) {         // 更新计数，当个数大于 1 时才更新
                    for(char c : String.valueOf(right - left).toCharArray()) {
                        chars[size++] = c;
                    }
                }
                left = right;
            }
        }
        System.out.println(size);
        for (int i = 0; i <chars.length ; i++) {
            System.out.println(chars[i]);
        }
        return size;

    }
}
