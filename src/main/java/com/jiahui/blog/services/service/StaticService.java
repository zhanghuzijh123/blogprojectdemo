package com.jiahui.blog.services.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;

/**
 * StaticService
 *
 * @author Administrator
 * @date 2021/10/20 0020
 */
@Slf4j
@Service
public class StaticService extends SuperService{
    public String name;
    private static String myName;

    public void test(){
        System.out.println(name);
        System.out.println(myName);
    }

//    public static void staticTest(){
//        System.out.println(myName);
//        System.out.println(name);
//        test();
//    }

    public void superTest(){
        System.out.println(super.name);
        System.out.println(this.name);
    }
}
