package com.jiahui.blog.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * TestVideo
 *
 * @author Administrator
 * @date 2021/9/7 0007
 */
public class TestVideo {
    public static boolean process(String resourcePath) {
        int type = checkContentType(resourcePath);
        boolean status = false;
        if (type == 0) {
            status = processFLV(resourcePath);// 直接将文件转为flv文件
        } else if (type == 1) {
            status = processFLV(resourcePath);// 将rmvb转为flv
        }
        return status;
    }

    private static int checkContentType(String resourcePath) {
        String type = resourcePath.substring(resourcePath.lastIndexOf(".") + 1, resourcePath.length()).toLowerCase();
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi")) {
            return 0;
        } else if (type.equals("mpg")) {
            return 0;
        } else if (type.equals("wmv")) {
            return 0;
        } else if (type.equals("3gp")) {
            return 0;
        } else if (type.equals("mov")) {
            return 0;
        } else if (type.equals("mp4")) {
            return 0;
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        } else if (type.equals("mpeg")) {
            return 0;
        } else if (type.equals("mpe")) {
            return 0;
        }
        // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
        // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
        else if (type.equals("wmv9")) {
            return 1;
        } else if (type.equals("rm")) {
            return 1;
        } else if (type.equals("rmvb")) {
            return 1;
        }
        return 9;
    }

    private static boolean checkfile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        }
        return true;
    }

    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
    @SuppressWarnings("unchecked")
    private static boolean processFLV(String resourcePath) {
        if (!checkfile(resourcePath)) {
            System.out.println(resourcePath + "   is   not   file");
            return false;
        }
        // 文件命名
        Calendar c = Calendar.getInstance();
        String savename = String.valueOf(c.getTimeInMillis()) + Math.round(Math.random() * 100000);
        List commend = new ArrayList();
        commend.add("e:\\ffmpeg");
        commend.add("-i");
        commend.add(resourcePath);
        commend.add("-ab");
        commend.add("56");
        commend.add("-ar");
        commend.add("22050");
        commend.add("-qscale");
        commend.add("8");
        commend.add("-r");
        commend.add("15");
        commend.add("-s");
        commend.add("600x500");
        commend.add("e:\\" + savename + ".flv");
        try {
            Runtime runtime = Runtime.getRuntime();
            Process proce = null;
            String cmd = "";
            String cut = "e://ffmpeg.exe -i" + resourcePath + " -y -f image2   -ss   8   -t   0.001   -s   600x500   e:\\" + savename + ".jpg";
            String cutCmd = cmd + cut;
            proce = runtime.exec(cutCmd);
            ProcessBuilder builder = new ProcessBuilder(commend);
            // builder.command(commend);
            builder.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
//        if (!checkfile("e:\\fly.avi")) {
//            System.out.println("" + "   is   not   file");
//            return;
//        }
        if (process("e:\\a.mpg")) {
            System.out.println("ok");
        }
    }
}
