package com.privilege.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5Util {
    public static String MD5Encoding(String name)  {
        //初始化MD5
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //创建base64位的编码格式
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //加密
        String encode = null;
        try {
            encode = base64Encoder.encode(name.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }
}
