package com.dranawhite.study.springboot.mail;

import java.io.File;
import java.util.List;

import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.common.exception.request.DranaIllegalArgumentException;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 * 邮件发送器
 *
 * @author dranawhite
 * @version : MailSender.java, v 0.1 2019-07-26 11:40 dranawhite Exp $$
 */
@MailService
public class MailClient {

    private static final String FROM_ADDRESS = "dranawhite@aliyun.com";
    private static final String FROM_NAME = "drana";
    @Autowired
    private JavaMailSender javaMailSender;

    public void prepareAndSend(List<UserVO> toUserList, String subject, String message) {
        prepareAndSend(toUserList, null, subject, message, null);
    }

    public void prepareAndSend(List<UserVO> toUserList, List<UserVO> copyUserList, String subject, String message) {
        prepareAndSend(toUserList, copyUserList, subject, message, null);
    }

    public void prepareAndSend(List<UserVO> toUserList, List<UserVO> copyUserList, String subject, String message,
                               List<File> attachmentList) {
        MimeMessagePreparator preparator = prepareMimeMessage(toUserList, copyUserList, subject, message,
                attachmentList);
        javaMailSender.send(preparator);
    }

    private MimeMessagePreparator prepareMimeMessage(List<UserVO> toUserList, List<UserVO> copyUserList, String subject,
                                                     String message, List<File> attachmentList) {
        if (CollectionUtils.isEmpty(toUserList)) {
            throw new DranaIllegalArgumentException("邮件收件人不能为空!", ResultCodeEnum.ILLEGAL_REQUEST);
        }

        // 通过MimeMessage类可以构建出比较复杂的邮件内容
        // MimeMessagePreparator提供一个构件模板的方法来构建MimeMessage，以及当你生成一个实例的时候帮你处理异常信息
        // 官方文档推荐使用MimeMessagePreparator作为邮件构建的首选类型
        // MimeMessageHelper是MimeMessage的装饰类，提供了更多开发人员友好的界面，并为类的许多属性添加了输入验证
        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(FROM_ADDRESS, FROM_NAME);
            for (UserVO toUser : toUserList) {
                messageHelper.addTo(toUser.getEmail(), toUser.getName());
            }
            if (CollectionUtils.isNotEmpty(copyUserList)) {
                for (UserVO copyUser : copyUserList) {
                    messageHelper.addCc(copyUser.getEmail(), copyUser.getName());
                }
            }
            messageHelper.setSubject(subject);
            messageHelper.setText(message, true);
            if (CollectionUtils.isNotEmpty(attachmentList)) {
                for (File attachment : attachmentList) {
                    messageHelper.addAttachment(attachment.getName(), attachment);
                }
            }
        };
        return preparator;
    }

}
