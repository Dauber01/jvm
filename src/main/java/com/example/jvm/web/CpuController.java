package com.example.jvm.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * cpu占用过高的测试用例
 *
 * @author Lucifer
 * @date 2018／11／28 22:19
 */
@RestController
public class CpuController {

    private Object object1 = new Object();

    private Object object2 = new Object();

    @GetMapping("/loop")
    public List<Long> loop(){
        String data = "{\"data\":[{\"partnerid]\":";
        return getPartneridsFromJson(data);
    }

    @GetMapping("/deadlock")
    public String deadLock(){
        new Thread(() -> {
            synchronized (object1){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println("Thread 1 run over");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object2){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println("Thread 2 run over");
                }
            }
        }).start();
        return "dead lock !";
    }


    public static List<Long> getPartneridsFromJson(String data){
        //{\"data\":[{\"partnerid\":982,\"count\":\"10000\",\"cityid\":\"11\"},{\"partnerid\":983,\"count\":\"10000\",\"cityid\":\"11\"},{\"partnerid\":984,\"count\":\"10000\",\"cityid\":\"11\"}]}
        //上面是正常的数据
        List<Long> list = new ArrayList<Long>(2);
        if(data == null || data.length() <= 0){
            return list;
        }
        int datapos = data.indexOf("data");
        if(datapos < 0){
            return list;
        }
        int leftBracket = data.indexOf("[",datapos);
        int rightBracket= data.indexOf("]",datapos);
        if(leftBracket < 0 || rightBracket < 0){
            return list;
        }
        String partners = data.substring(leftBracket+1,rightBracket);
        if(partners == null || partners.length() <= 0){
            return list;
        }
        while(partners!=null && partners.length() > 0){
            int idpos = partners.indexOf("partnerid");
            if(idpos < 0){
                break;
            }
            int colonpos = partners.indexOf(":",idpos);
            int commapos = partners.indexOf(",",idpos);
            if(colonpos < 0 || commapos < 0){
                //partners = partners.substring(idpos+"partnerid".length());//1
                continue;
            }
            String pid = partners.substring(colonpos+1,commapos);
            if(pid == null || pid.length() <= 0){
                //partners = partners.substring(idpos+"partnerid".length());//2
                continue;
            }
            try{
                list.add(Long.parseLong(pid));
            }catch(Exception e){
                //do nothing
            }
            partners = partners.substring(commapos);
        }
        return list;
    }


}
