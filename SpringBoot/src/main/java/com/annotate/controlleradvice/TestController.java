package com.annotate.controlleradvice;

import io.netty.handler.codec.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Hanz
 * @date 2020/6/4
 */
@RestController
@RequestMapping(path = "/handler")
public class TestController {
    @RequestMapping("/testException")
    public String testException() throws Exception {
        throw new MissingServletRequestParameterException("name", "String");
    }

    @GetMapping("/testMyException")
    public String testMyException(HttpServletRequest httpRequest) throws MyException {
        RequestContext requestContext = new RequestContext(httpRequest);
        System.out.println(requestContext.toString());
        throw new MyException("i am a myException");
    }
}
