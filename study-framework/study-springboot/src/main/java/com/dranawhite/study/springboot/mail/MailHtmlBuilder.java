package com.dranawhite.study.springboot.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 *
 * @author dranawhite
 * @version : MailHtmlBuilder.java, v 0.1 2019-07-26 15:35 dranawhite Exp $$
 */
@MailService
public class MailHtmlBuilder {

    @Autowired
    private TemplateEngine templateEngine;

    public String toHtml(String tplName, Context context) {
        return templateEngine.process(tplName, context);
    }
}
