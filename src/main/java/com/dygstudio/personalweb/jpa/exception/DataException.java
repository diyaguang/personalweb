package com.dygstudio.personalweb.jpa.exception;

/**
 * @author: diyaguang
 * @date: 2018/02/08 上午11:53
 * @description: com.dygstudio.personalweb.jpa.exception
 */
public class DataException extends RuntimeException {
    public int code;

    public final static int noPermission = -100;
    public final static int noID = -1;

    public DataException(int code) {
        this.code = code;
    }

    public DataException(int code , String message) {
        super(message);
        this.code = code;
    }

    public DataException(int code , String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public DataException(int code , Throwable cause) {
        super(cause);
        this.code = code;
    }
}
