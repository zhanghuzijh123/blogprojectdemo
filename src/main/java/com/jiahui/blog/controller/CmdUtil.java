package com.jiahui.blog.controller;

import java.io.*;

/**
 * CmdUtil
 *
 * @author Administrator
 * @date 2021/9/8 0008
 */
public class CmdUtil {
    public void executeCMDconsole(String[] cmd) {
        //此方法为打印日志到控制台！！！！！！！！！！！！
        //此方法跑成功！！！

        System.out.println("在cmd里面输入" + cmd);
        Process p;
        try {
            String commands[] = {"D:\\ffmpeg-2021-09-05-git-a947098558-full_build\\bin"};
            p = Runtime.getRuntime().exec(cmd,commands);
            System.out.println(":::::::::::::::::::开始在控制台打印日志::::::::::::::::::::::>>>>>>");
            //p.waitFor();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));
            String line = null;
            StringBuffer b=new StringBuffer();
            while ((line = bReader.readLine()) != null){
                b.append(line+"\n");
            }
            System.out.println(b.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String executeCMDfile(String[] cmmands, String logToFile, String dirTodoCMD) throws IOException {
        //此方法为輸出日志到指定文件夹！！！！！！！！！！！！
        //此方法跑成功！！！
        //如果 String cmmand 那麼  String cmmand = "adb logcat -v time > d:/adb.log";
        //String[] cmmands 所以   String commands[] = { "adb", "logcat","-v","time"};
        //String logToFile  將日誌保存到logToFile
        //String dirTodoCMD 在dirTodoCMD執行cmd命令
        //由于將日志輸出到文件裡面了，就不能再将日誌輸出到console了

        try {
            ProcessBuilder builder = new ProcessBuilder(cmmands);
            if (dirTodoCMD != null)
                builder.directory(new File(dirTodoCMD));
            builder.redirectErrorStream(true);
            builder.redirectOutput(new File(logToFile));
            Process process = builder.start();
            process.waitFor();
            // 得到命令执行后的结果
            InputStream is = process.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(is, "gbk"));
            String line = null;
            StringBuffer sbBuffer = new StringBuffer();
            while ((line = buffer.readLine()) != null) {
                sbBuffer.append(line);
            }

            is.close();
            return sbBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
