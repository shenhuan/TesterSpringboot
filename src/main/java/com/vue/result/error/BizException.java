package com.vue.result.error;


import com.vue.utils.StraceStackPrinterUtil;

/**
 * @author shaok
 * @description: 通用错误处理
 */
public class BizException extends RuntimeException {

    /**
     * 错误枚举
     */
    private ExceptionInfoEnum error;

    /**
     * 错误code
     */
    private Integer errCode;

    /**
     * 详细信息
     */
    private String errMsg;

    /**
     * 默认code
     */
    private Integer statusCode = 200;

    /**
     * 错误堆栈
     */
    private String errStack;

    public BizException(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public BizException(ExceptionInfoEnum error) {
        this.error = error;
        this.errCode = null == error?null:error.getCode();
        this.errMsg = null == error?null:error.getMessage();
    }

    public BizException(ExceptionInfoEnum error, Exception e) {
        this.error = error;
        this.errStack = StraceStackPrinterUtil.printStackTraceToString(e);
    }

    public BizException(String msg) {
        this.errMsg = msg;
    }

    public String getErrStack() {
        return errStack;
    }

    public void setErrStack(String errStack) {
        this.errStack = errStack;
    }

    public ExceptionInfoEnum getError() {
        return error;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }


    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
