package org.tank.core.tool.exception;

import lombok.extern.slf4j.Slf4j;
import org.tank.core.tool.result.IResultCode;
import org.tank.core.tool.result.ResultCode;

/**
  * @description 分布式锁异常处理
  * @author lbx
  * @date 2019/12/2 12:48
  * @version 1.0.0
 **/
@Slf4j
public class LockException extends RuntimeException  {

    private static final long serialVersionUID = -6539904944585008606L;

    private Integer code;

    private String  message;

    public LockException() {
        super();
    }

    public LockException(String message) {
        super(message);
        this.code = ResultCode.FAILURE.getCode();
        this.message =message;
    }

    public LockException(String message, Integer code) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public LockException( Integer code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public LockException(IResultCode resultCode,Throwable cause) {
        super(cause);
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
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
