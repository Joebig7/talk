package com.mamba.talk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author JoeBig7
 * @date 2021/2/18 18:07:21
 */
public class Md5Util {


    public final static String MD5(String pwd) {
        //用于加密的字符
        char[] md5String = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};

        //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
        return getMessageDigest("MD5", pwd, md5String);

    }

    private static String getMessageDigest(String type, String pwd, char[] md5String) {
        try {
            MessageDigest mdInst = MessageDigest.getInstance(type);

            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
            byte[] btInput = pwd.getBytes();

            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
            mdInst.update(btInput);

            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = md5String[byte0 >>> 4 & 0xf];
                str[k++] = md5String[byte0 & 0xf];
            }

            //返回经过加密后的字符串
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
