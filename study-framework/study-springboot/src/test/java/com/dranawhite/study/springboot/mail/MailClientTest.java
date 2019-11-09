package com.dranawhite.study.springboot.mail;

import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.study.springboot.BaseTest;
import com.dranawhite.study.springboot.model.user.UserVO;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;

import lombok.extern.slf4j.Slf4j;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 使用GreenMail做邮件单元测试
 *
 * @author dranawhite
 * @version : MailClientTest.java, v 0.1 2019-07-26 14:48 dranawhite Exp $$
 */
@Slf4j
public class MailClientTest extends BaseTest {

    private GreenMail smtpServer;

    @Autowired
    private MailClient mailClient;

    @Before
    public void setUp() {
        ServerSetup server = new ServerSetup(25, "127.0.0.1", ServerSetup.PROTOCOL_SMTP);
        smtpServer = new GreenMail(server);
        smtpServer.setUser("root", "123456");
        smtpServer.start();
    }

    @After
    public void tearDown() {
        smtpServer.stop();
    }

    @Test
    public void testCommonTextMail() {
        UserVO toUser = new UserVO();
        toUser.setEmail("dranawhite@aliyun.com");
        toUser.setName("drana");
        List<UserVO> toUserList = new ArrayList<>();
        toUserList.add(toUser);
        String subject = "Test Mail";
        String message = "<h1>Hello World!</h1>";

        mailClient.prepareAndSend(toUserList, subject, message);
        assertReceivedMessageContains(subject);
    }

    private void assertReceivedMessageContains(String subject) {
        MimeMessage[] mimeMessageArr = smtpServer.getReceivedMessages();
        Assert.assertEquals(1, mimeMessageArr.length);

        try {
            String receivedSubject = mimeMessageArr[0].getSubject();
            Assert.assertEquals(subject, receivedSubject);
            log.info("Test Mail Subject: [{}]", subject);
        } catch (MessagingException ex) {
            throw new DranaSystemException("GreenMail获取邮件时报错", ResultCodeEnum.SYSTEM_ERR, ex);
        }
    }
}
