package com.test201908;

import java.util.Scanner;

/**
 * @author frank
 * @create 2019-12-29 10:55
 *
 *     从键盘读入学生成绩，找出最高分，并输出学生成绩等级。
 *       成绩>=最高分-10    等级为’A’
 *       成绩>=最高分-20    等级为’B’
 *       成绩>=最高分-30    等级为’C’
 *      其余                等级为’D’
 *      提示：先读入学生人数，根据人数创建int数组，存放学生成绩
 *
 *
 *
 */
public class JudgeHighScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //先读入学生人数
        System.out.println("先读入学生人数:");
        int length = scanner.nextInt();
        int[] score = new int[length];
        int maxScore = 0;
        for (int i = 0; i < score.length; i++) {
            System.out.println("请输入分数:");
            score[i] = scanner.nextInt();
            if (score[i]>maxScore){
                maxScore = score[i];
            }
        }

        System.out.println("最高分是:" +maxScore);
        for (int i = 0; i <score.length ; i++) {
            String level = "";
            if (score[i] >= maxScore-10){
                level = "A";
            }else if (score[i] >= maxScore-20){
                level = "B";
            }else if (score[i] >= maxScore-30){
                level = "C";
            }else {
                level = "D";
            }
            System.out.println("student "+i+" score is "+score[i]+" grade is "+level);
        }
    }
}
