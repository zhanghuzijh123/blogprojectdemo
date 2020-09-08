package com.jiahui.blog.controller;

import com.jiahui.blog.pojo.User;
import com.jiahui.blog.response.ResponseResult;
import com.jiahui.blog.response.ResponseState;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * springboot方法测试
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ArrayList<Integer> helloHello(){
        //java8新的时间日期API
        System.out.println("java8新的时间日期API------------------");
        LocalDateTime dt=LocalDateTime.now();
        System.out.println(dt);
        LocalDate dt1=dt.toLocalDate();
        System.out.println(dt1);
        Month month=dt.getMonth();
        int day=dt.getDayOfMonth();
        int second=dt.getSecond();
        System.out.println(month+"月"+day+"日"+second+"秒");
        //java foreach()+lambda表达式
        System.out.println("java foreach()+lambda表达式------------------");
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
        //冒泡排序
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

    /**
     * java8新特性Stream csdn链接:https://blog.csdn.net/y_k_y/article/details/84633001
     */
    @RequestMapping(value = "/stream",method = RequestMethod.GET)
    public void streamTest(){
        /* filter：过滤流中的某些元素
        limit(n)：获取n个元素
        skip(n)：跳过n元素，配合limit(n)可实现分页
        distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素 */
        Stream<Integer> stream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        Stream<Integer> newStream = stream.filter(s -> s > 5) //6 6 7 9 8 10 12 14 14
                .distinct() //6 7 9 8 10 12 14
                .skip(2) //9 8 10 12 14
                .limit(2); //9 8
        newStream.forEach(System.out::println);

        List<String> list = Arrays.asList("a,b,c", "1,2,3");
        //将每个元素转成一个新的且不带逗号的元素
        Stream<String> s1 = list.stream().map(s -> s.replaceAll(",", ""));
        s1.forEach(System.out::println); // abc  123
        Stream<String> s3 = list.stream().flatMap(s -> {
            //将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        });
        s3.forEach(System.out::println); // a b c 1 2 3

    }

    @GetMapping(value = "/returnResult")
    public ResponseResult responseResult(){
        /*ResponseResult responseResult=new ResponseResult(ResponseState.SUCCESS);
        return responseResult;*/
        User user=new User();
        user.setUserName("nikoo");
        user.setPassword("111111");
        return ResponseResult.SUCCESS().setData(user);
    }
}
