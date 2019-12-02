package org.tank.core.tool.exception;

import lombok.extern.slf4j.Slf4j;
import org.tank.core.tool.result.IResultCode;
import org.tank.core.tool.result.ResultCode;

/**
  * @description 业务异常处理
  * @author lbx
  * @date 2019/12/2 12:51
  * @version 1.0.0
 **/
@Slf4j
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 2312886932744141223L;

    private Integer code;

    private String  message;


    public CustomException() {
        super();
        this.code = ResultCode.FAILURE.getCode();
        this.message = ResultCode.FAILURE.getMessage();
    }

    public CustomException(String message) {
        super(message);
        this.code = ResultCode.FAILURE.getCode();
        this.message =message;
    }

    public CustomException(Throwable cause) {
        super(cause);
        this.code = ResultCode.FAILURE.getCode();
        this.message = ResultCode.FAILURE.getMessage();
    }

    public CustomException(IResultCode resultCode,Throwable cause) {
        super(cause);
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public CustomException(IResultCode resultCode) {
        super();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public CustomException(Integer code,String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
