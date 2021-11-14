package com.vue.result;

import com.vue.result.error.BizException;
import com.vue.result.error.ExceptionInfoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回体
 */
@Data
public class ResponseData {
    public static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";

    public static final String DEFAULT_ERROR_MESSAGE = "网络异常";

    public static final Integer DEFAULT_SUCCESS_CODE = 200;

    public static final Integer DEFAULT_ERROR_CODE = 500;

    /**
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应对象
     */
    private Object data;

    public ResponseData() {
    }

    public ResponseData(Boolean success, Integer code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseData(ExceptionInfoEnum exceptionInfoEnum){
        this.code = exceptionInfoEnum.getCode();
        this.message = exceptionInfoEnum.getMessage();
    }

    public static SuccessResponseData success() {
        return new SuccessResponseData();
    }

    public static SuccessResponseData success(Object object) {
        return new SuccessResponseData(object);
    }

    public static SuccessResponseData success(Integer code, String message, Object object) {
        return new SuccessResponseData(code, message, object);
    }

    public static ErrorResponseData error(String message) {
        return new ErrorResponseData(message);
    }

    public static ErrorResponseData error(BizException e){
        Integer errCode = e.getErrCode();
        return new ErrorResponseData(null == errCode ? 500 : e.getErrCode(),e.getErrMsg());
    }

    public static ErrorResponseData error(Integer code, String message) {
        return new ErrorResponseData(code, message);
    }

    public static ErrorResponseData error(Integer code, String message, Object object) {
        return new ErrorResponseData(code, message, object);
    }

    public static ErrorResponseData error(ExceptionInfoEnum exceptionInfoEnum){
        return new ErrorResponseData(exceptionInfoEnum.getCode(),exceptionInfoEnum.getMessage());
    }

}
