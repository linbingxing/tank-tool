package org.tank.core.tool.api;

/**
 * @author lbx
 * @version 1.0.0
 * @interfaceName IResultCode
 * @description 务代码接口
 * @date 2022/1/5 13:03
 **/
public interface IResultCode {

    /**
     * 状态码
     *
     * @return int
     */
    int getCode();

    /**
     * 消息
     *
     * @return String
     */
    String getMessage();


}
