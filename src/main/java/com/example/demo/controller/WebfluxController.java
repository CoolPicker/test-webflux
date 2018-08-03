package com.example.demo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by niuya on 2018/5/22.
 */
@RestController
public class WebfluxController {

    @RequestMapping(value = "/hi")
    public String sayHello(){
        return "welcome to webflux !";
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String sc = "face_check~!@#";
        String openid = "1710194255927647";
        String username = "niuya";
        long l = System.currentTimeMillis()/1000;
        System.out.println(l);
        String mm = username + openid + sc + l ;
        System.out.println(mm);
        String s = MD5Utils.getMD5(mm);
        System.out.println(s);



    }

    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    public static Map test(Map map){
        HashMap hashMap = (HashMap) map;
        hashMap.put("haha","2323");
        return map;
    }

}
