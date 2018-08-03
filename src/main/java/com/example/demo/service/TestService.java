package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.entity.XiaoMing;
import com.example.demo.util.ListToArray;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestService {

    String aa = new String();


    public void sayHello(){
        System.out.println(aa);
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public static void main(String[] args) {
        XiaoMing xiaoMing;
        List<XiaoMing> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ){


            xiaoMing = new XiaoMing();
            xiaoMing.setMm("mm"+i);
            xiaoMing.setNn("nn"+i);

            xiaoMing.setId(i+100);
            xiaoMing.setAa("aa"+i);
            xiaoMing.setBb("bb"+i);
            xiaoMing.setCc("cc"+i);
            xiaoMing.setDd("dd"+i);

            //xiaoMing.setId(null);
            //xiaoMing.setBb(null);
            list.add(xiaoMing);
        }

        ListToArray listToArray = new ListToArray();
        String[][] strings = listToArray.listToArrayWay(list);
        System.out.println(strings);


//        Map map;
//        List<Map> list1 = new ArrayList<>();
//        for (int i = 0 ; i < 10 ; i++){
//            map = new HashMap();
//            map.put("0",i+"ii");
//            map.put("1","aa+"+i);
//            map.put("2","bb+"+i);
//            map.put("3","cc+"+i);
//            map.put("4","dd+"+i);
//            list1.add(map);
//        }
//
//        ListToArray listToArray = new ListToArray();
//        String[][] strings = listToArray.listToArrayWay(list1);
    }

}
