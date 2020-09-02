package com.jiahui.blog.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ArrayList<Integer> helloHello(){
        LocalDateTime dt=LocalDateTime.now();
        System.out.println(dt);
        LocalDate dt1=dt.toLocalDate();
        System.out.println(dt1);
        HashMap<String,Integer> map=new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);
        map.forEach((i,j)->{
            if (i.equals("B")){
                System.out.println("Hello B"+"------------------"+j);
            }
        });
        ArrayList<Integer> ary=new ArrayList<>();
        ary.add(0,4);
        ary.add(1,2);
        ary.add(2,5);
        ary.add(3,1);
        ary.add(4,9);
        int a=0;
        for (int i=0;i<ary.size();i++){
            for (int j=i;j<ary.size();j++){
                if (ary.get(i)<ary.get(j)){
                    a=ary.get(i);
                    ary.set(i,ary.get(j));
                    ary.set(j,a);
                }
            }
        }
        return ary;
    }
}
