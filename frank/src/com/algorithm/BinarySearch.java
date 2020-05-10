package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author frank
 * @create 2020-02-21 11:46
 * @implSpec 二分查找算法
 * @implNote 二分查找算法只能对有顺序的数组进行查找，从小到大排列或者从大到小排列
 * 请对一个有序数组进行二分查找 {1,8, 10, 89, 1000, 1234} ，输入一个数看看该数组是否存在此数，并且求出下标，如果没有就提示"没有这个数"
 */
public class BinarySearch {
    public static void main(String[] args) {
/*        int[] arr = {1,8, 10, 89, 1000, 1234};
        int a =binarySearch(arr,0,arr.length-1,1234);
        System.out.println(a);*/


        int[] arr = {1 ,8, 10, 89, 1000, 1000,1234};
        List list = binarySearch2(arr,0,arr.length,1000);
        System.out.println(list);
    }

    /**
     * @param arr     数组
     * @param left    最左边的下标
     * @param right   最右边的下标
     * @param findVal 要查找的数值
     * @return 要查数的下标，没有查到返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal < midVal) {
            return binarySearch(arr,left,mid-1,findVal);
        }else if (findVal>midVal){
            return binarySearch(arr,mid+1,right,findVal);
        }else{
            return mid;
        }
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     *
     * @implSpec {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
     */
    public static List<Integer> binarySearch2(int[] arr,int left,int right,int findVal){
        List<Integer> list = new ArrayList<Integer>();
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if (findVal<midVal){
            return binarySearch2(arr,left,mid-1,findVal);
        }else if (findVal>midVal){
            return binarySearch2(arr,mid+1,right,findVal);
        }else {

            //向左扫描
            int temp = mid-1;
            while (true){
                if (temp<0 || arr[temp]!=arr[mid])break;
                list.add(temp);
                temp--;
            }

            list.add(mid);

            //向右扫描
            temp = mid + 1;
            while (true){
                if (temp >arr.length-1 || arr[temp] != arr[mid])break;
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
