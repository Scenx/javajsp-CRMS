package com.scen.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 字符串工具类
 *
 * @author Scen
 * @date 2018/2/14
 */
public class MyStringUtils {

    /**
     * 获得MD5加密后的数据
     *
     * @param value 明文
     * @return 密文
     */
    public static String getMD5Value(String value) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
            BigInteger bigInteger = new BigInteger(1, md5ValueByteArray);
            return bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            //如果出现异常 返回默认值
            return value;
        }
    }

    /**
     * 获得一个32长度的UUID
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
