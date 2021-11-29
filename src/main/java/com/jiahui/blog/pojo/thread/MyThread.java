package com.jiahui.blog.pojo.thread;

/**
 * MyThread
 *
 * @author Administrator
 * @date 2021/11/18 0018
 */
public class MyThread extends Thread{
    private String name;

    public MyThread(String name){
        this.name = name;
    }

    /**
     * 这就是线程执行的逻辑体
     */
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(name+"下载了"+i+"%");
        }
    }
}
