package org.tank.tool.core.constant;

/**
  * @description 系统常量
  * @author lbx
  * @date 2019/11/30 14:47
  * @version 1.0.0
 **/
public interface SystemConstant {

    /**
     * 默认成功消息
     */
    String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    /**
     * 默认失败消息
     */
    String DEFAULT_FAILURE_MESSAGE = "操作失败";
    /**
     * 默认为空消息
     */
    String DEFAULT_NULL_MESSAGE = "数据为空";
    /**
     * 默认未授权消息
     */
    String DEFAULT_UNAUTHORIZED_MESSAGE = "签名认证失败";

    /**
     * 系统默认删除状态[0:正常,1:删除]
     */
    Integer DB_NOT_DEL = 0;

    Integer DB_DEL_FLAG = 1;



}
