package com.jiahui.blog;

import com.jiahui.blog.utils.EmailSender;

import javax.mail.MessagingException;

public class TestEmailSender {
    public static void main(String[] args) throws MessagingException {
        EmailSender.subject("测试邮件发送").from("测试系统").text("洋葱头是猪").to("1027262824@qq.com").send();
    }
}
