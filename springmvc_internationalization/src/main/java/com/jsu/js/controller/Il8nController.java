package com.jsu.js.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @author: sunc-idea
 * @Date: 2020/4/26
 */

@Controller
@RequestMapping("il8n")
public class Il8nController {

    //@RequestMapping("sessionLocaleResover")
    public String test(HttpSession session, @RequestParam("requst_Locale") String requst_Locale) {
      /*  if (!requst_Locale.isEmpty()) {

            if ("zh_CN".equals(requst_Locale)) {

                Locale local = new Locale("zh", "CN");
                session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, local);

            } else if ("en_US".equals(requst_Locale) ) {

                Locale local = new Locale("en", "US");
                session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, local);
            }

        } else {

            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
        }*/
        return "success";
    }
}
