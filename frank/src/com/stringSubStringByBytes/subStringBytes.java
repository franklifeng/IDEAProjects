package com.stringSubStringByBytes;

import java.io.UnsupportedEncodingException;

/**
 * java面试题
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
 * 但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"，6，
 * 应该输出为"我ABC"而不是"我ABC+汉的半个"。
 *
 * @author frank
 * @create 2019-09-02 15:50
 */
public class subStringBytes {
    /**
     * 判断是否是一个汉字
     *
     * @param  c
     *      要判断的字符
     * @param charset
     *      字符编码格式(GBK,UTF-8等)
     * @return true表示是汉字，false表示不是汉字
     *
     * @throws UnsupportedEncodingException 使用了java不支持的编码格式
     *
     */
    public static boolean isChineseChar(char c,String charset) throws UnsupportedEncodingException {
        return String.valueOf(c).getBytes(charset).length>1;
    }

    /**
     * 计算一个char字符转换为byte字节长度
     * @param c
     *     要计算的字符
     * @param charset
     *     字符编码格式(GBK,UTF-8等)
     *
     * @throws UnsupportedEncodingException 使用了java不支持的编码格式
     */
    public static Integer getByteCharLen(char c,String charset) throws UnsupportedEncodingException {
        return String.valueOf(c).getBytes(charset).length;
    }

    /**
     * 得到字符串转换为byte的总字节长度
     * @param str
     * @return 总字节长度
     * @throws UnsupportedEncodingException 使用了java不支持的编码格式
     */
    public static int getStringByteLengths(String str,String charset)throws UnsupportedEncodingException{
        return str!=null&!"".equals(str)?str.getBytes(charset).length:0;
    }

    /**
     * 把一个带汉字的字符串转换为字节byte再来截取，解决只能截取半个汉字的问题，不使用此方法会截取半个汉字为？号
     * @param str 要截取的字符串
     * @param start 截取的起始字节位置
     * @param count  截取的字节长度
     * @param charset 字符编码格式(GBK,UTF-8等)
     * @return
     * @throws UnsupportedEncodingException 使用了java不支持的编码格式
     *
     */
    public static String subStringByByte(String str,int start,int count,String charset)throws UnsupportedEncodingException{
        if (str==null||"".equals(str))return str;
        if (count<=0)return str;
        if (start<0)start=0;
        StringBuffer buffer = new StringBuffer();
        char[] chars = str.toCharArray();
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            len += getByteCharLen(chars[i],charset);
            if (start==0){
                if (len<=count)buffer.append(chars[i]);else break;
            }else{
                if (len>=start&&len<=start+count){
                    buffer.append(chars[i]);
                }
                if (len>start+count)break;
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "帅帅ABCD衰";
        System.out.println(getStringByteLengths(str,"GBK"));
        System.out.println(subStringByByte(str,4,8,"GBK"));
    }
}
