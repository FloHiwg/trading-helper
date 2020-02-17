package com.heiwig.tradinghelper.controllers;

import com.auth0.SessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping(value = "/protected")
public class ProtectedController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    protected String home(final Map<String, Object> model, final HttpServletRequest req){
        String accessToken = (String)SessionUtils.get(req, "accessToken");
        String idToken = (String)SessionUtils.get(req, "idToken");
        if (accessToken != null) {
            model.put("userId", accessToken);
        } else if (idToken != null) {
            model.put("userId", idToken);
        }
        return "protected/home";
    }
}
