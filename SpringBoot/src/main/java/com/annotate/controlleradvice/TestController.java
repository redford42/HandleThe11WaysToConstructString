package com.annotate.controlleradvice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hanz
 * @date 2020/6/4
 */
@RestController
@RequestMapping(path="/handler")
public class TestController {
    @RequestMapping("/testException")
    public String testException() throws Exception{
        throw new MissingServletRequestParameterException("name","String");
    }

    @GetMapping("/testMyException")
    public String testMyException() throws MyException{
        throw new MyException("i am a myException");
    }
}
