package com.algorithm.mianshi;

import java.util.Scanner;

/**
 * @author frank
 * @create 2020-02-28 10:43
 * @implSpec 金额转换，阿拉伯数字的金额转换成中国传统的形式。如：105600123 => 壹亿零仟伍佰陆拾零万零仟壹佰贰拾叁圆整
 * <p>
 * 零、壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿
 */
public class AmountCNTransfer {

    private static final char[] AMOUNT = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};

    private static final char[] MONEY_UNIT = {'圆', '拾', '佰', '仟', '万','拾', '佰', '仟', '亿','拾', '佰', '仟'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        String money = transfer(a);
        System.out.println("转换的中文金额是: " +money);

    }

    public static String transfer(int money) {
        StringBuffer str = new StringBuffer("整");
        int init = 0;
        while (money != 0) {
            str.insert(0, MONEY_UNIT[init++]);
            int temp = money % 10;
            str.insert(0, AMOUNT[temp]);
            money /= 10;
        }
        return str.toString();
    }
}
