/**
 * projectName: frank
 * fileName: isChinese.java
 * packageName: com.cenboomh
 * date: 2021-06-24 17:52
 * copyright(c) 2017-2020 cenboomh
 */
package com.cenboomh;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version: V1.0
 * @author: fli
 * @className: isChinese
 * @packageName: com.cenboomh
 * @description: 判定输入的是否是汉字
 * @data: 2021-06-24 17:52
 **/
public class isChinese {
    public static void main(String[] args) {
        String str = "wo是李了";
        System.out.println(checkNameChese(str));

        System.out.println(validateLegalString("#"));
        System.out.println("这是一个测试");

    }


    /**
     * 验证字符串内容是否包含下列非法字符<br>
     * `~!#%^&*=+\\|{};:'\",<>/?○●★☆☉♀♂※¤╬の〆
     *
     * @param content   字符串内容
     * @return 't'代表不包含非法字符，otherwise代表包含非法字符。
     */
    public static char validateLegalString(String content) {
        String illegal = "`~!#%^&*=+\\|{};:'\",<>/?○●★☆☉♀♂※¤╬の〆";
        char isLegalChar = 't';
        //L1定义代码块L1
        Code1:for (int i = 0; i < content.length(); i++) {
            for (int j = 0; j < illegal.length(); j++) {
                if (content.charAt(i) == illegal.charAt(j)) {
                    isLegalChar = content.charAt(i);
                    break Code1;
                }
            }
        }
        return isLegalChar;

    }

    /**
     * 校验一个字符是否是汉字
     *
     * @param c
     *      被校验的字符
     * @return true代表是汉字
     */
    public static boolean isChineseChar(char c) {
        try {
            return String.valueOf(c).getBytes("UTF-8").length > 1;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判定输入的是否是汉字
     *
     * @param c
     *      被校验的字符
     * @return true代表是汉字
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }


    /**
     * 校验String是否全是中文
     *
     * @param name
     *      被校验的字符串
     * @return true代表全是汉字
     */
    public static boolean checkNameChese(String name) {
        boolean res = true;
        char[] cTemp = name.toCharArray();//转换为数组
        for (int i = 0; i < name.length(); i++) {
            if (!isChinese(cTemp[i])) {//逐个判断是否为中文
                res = false;
                break;
            }
        }
        return res;
    }


    /**
     * 验证是否是汉字或者0-9、a-z、A-Z
     *
     * @param c
     *      被验证的char
     * @return true代表符合条件
     */
    public static boolean isRightChar(char c) {
        return isChinese(c) || isWord(c);
    }

    /**
     * 校验某个字符是否是a-z、A-Z、_、0-9
     *
     * @param c
     *      被校验的字符
     * @return true代表符合条件
     */
    public static boolean isWord(char c) {
        String regEx = "[\\w]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher("" + c);
        return m.matches();
    }
}
