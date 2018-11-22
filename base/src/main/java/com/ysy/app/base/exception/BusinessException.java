package com.ysy.app.base.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @Copyright: Copyright (c) 2018
 * @Company: 云手艺
 * @Version: V2018.10.0.0.1
 * @PackageName: com.ysy.app.base.exception
 * @ProjectName: app
 * @Auther: 赵家豪
 * @Date: 2018/10/18 0018 10:54
 * @Description:
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = 1499727967420270973L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * 重写父类的方法
     */

    @Override
    public String getMessage() {
        //  Auto-generated method stub
        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        //  Auto-generated method stub
        return super.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        //  Auto-generated method stub
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        //  Auto-generated method stub
        return super.initCause(cause);
    }

    @Override
    public String toString() {
        //  Auto-generated method stub
        return super.toString();
    }

    @Override
    public void printStackTrace() {
        //  Auto-generated method stub
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        //  Auto-generated method stub
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        //  Auto-generated method stub
        super.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        //  Auto-generated method stub
        return super.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        //  Auto-generated method stub
        return super.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        //  Auto-generated method stub
        super.setStackTrace(stackTrace);
    }

    @Override
    public int hashCode() {
        //  Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        //  Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //  Auto-generated method stub
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        //  Auto-generated method stub
        super.finalize();
    }


}
