package com.annotate.controlleradvice;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hanz
 * @date 2020/6/4
 */
//@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 400);
        //判断异常的类型,返回不一样的返回值
        if (ex instanceof MissingServletRequestParameterException) {
            map.put("msg", "缺少必需参数：" + ((MissingServletRequestParameterException) ex).getParameterName());
        } else if (ex instanceof MyException) {
            map.put("msg", "这是自定义异常");
        }
        return map;
    }

//    @ExceptionHandler(value = MyException.class)
//    public ModelAndView myErrorHandler(MyException ex) {
//        ModelAndView modelAndView = new ModelAndView();
//        //指定错误页面的模板页
//        modelAndView.setViewName("error");
//        modelAndView.addObject("code", ex.getCode());
//        modelAndView.addObject("msg", ex.getMsg());
//        return modelAndView;
//    }
}
