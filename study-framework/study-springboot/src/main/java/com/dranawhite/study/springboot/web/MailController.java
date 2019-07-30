package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaRequest;
import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.common.validate.annotation.InsertGroup;
import com.dranawhite.study.springboot.mail.MailClient;
import com.dranawhite.study.springboot.mail.MailHtmlBuilder;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用thymeleaf发送邮件
 *
 * @author dranawhite
 * @version : MailController.java, v 0.1 2019-07-26 13:52 dranawhite Exp $$
 */
@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private MailHtmlBuilder mailHtmlBuilder;

    @PostMapping("/send")
    public DranaResponse<Boolean> sendMail(@RequestBody @Validated(InsertGroup.class) DranaRequest<UserVO> request) {
        UserVO toUser = request.getData();
        List<UserVO> toUserList = new ArrayList<>();
        UserVO toCopiedUser = new UserVO();
        BeanUtils.copyProperties(toUser, toCopiedUser);
        toCopiedUser.setId(12);
        toUserList.add(toUser);
        toUserList.add(toCopiedUser);

        String subject = "Test Mail";
        // 组装thymeleaf模板数据
        Context context = new Context();
        context.setVariable("user", toUser);
        context.setVariable("userList", toUserList);
        context.setVariable("imageResourceName", "img_1");
        String html = mailHtmlBuilder.toHtml("mailTemplate", context);

        mailClient.prepareAndSend(toUserList, subject, html);
        return DranaResponse.success(Boolean.TRUE);
    }
}
