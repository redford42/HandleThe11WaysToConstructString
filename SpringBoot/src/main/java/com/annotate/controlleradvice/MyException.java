package com.annotate.controlleradvice;

import lombok.Data;

/**
 * @author Hanz
 * @date 2020/6/4
 */
@Data
public class MyException extends RuntimeException{
    private long code;
    private String msg;

    public MyException(Long code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public MyException(String msg){
        super(msg);
        this.msg = msg;
    }
}
