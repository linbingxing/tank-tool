package org.tank.core.tool.result;

import java.io.Serializable;

/**
  * @description 业务返回类型
  * @author lbx
  * @date 2019/11/30 14:05
  * @version 1.0.0
 **/
public interface IResultCode extends Serializable {

    /**
     * 消息
     *
     * @return String
     */
    String getMessage();

    /**
     * 状态码
     *
     * @return int
     */
    int getCode();

}
