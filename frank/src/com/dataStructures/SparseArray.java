package com.dataStructures;

/**
 * @author frank
 * @create 2020-03-18 11:00
 * @implSpec 稀疏数组   二维数据转化为稀疏数组，稀疏数组在恢复成二维数组
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] arrays = new int[11][11];
        arrays[1][2] = 1;
        arrays[2][3] = 2;
   /*     for (int[] arr : arrays){
            for (int item : arr){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }*/

        int num = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.printf("%d\t", arrays[i][j]);
                if (arrays[i][j] != 0) {
                    num++;
                }
            }
            System.out.println();
        }

        int[][] sparseArray = new int[num + 1][3];
        sparseArray[0][0] = arrays.length;
        sparseArray[0][1] = arrays[0].length;
        sparseArray[0][2] = num;

        int count = 0;

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (arrays[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = arrays[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        int[][] array2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            array2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int[] arr : array2) {
            for (int item : arr) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
     }
}
