package org.tank.core.tool.result;

import javax.servlet.http.HttpServletResponse;

/**
  * @description 业务返回类型
  * @author lbx
  * @date 2019/11/30 14:16
  * @version 1.0.0
 **/
public enum  ResultCode implements IResultCode {
    SUCCESS(0, "成功"),
    FAILURE(HttpServletResponse.SC_BAD_REQUEST, "业务异常"),
    UN_AUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "请求未授权"),
    NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, "404 没找到请求"),
    MSG_NOT_READABLE(HttpServletResponse.SC_BAD_REQUEST, "消息不能读取"),
    METHOD_NOT_SUPPORTED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "不支持当前请求方法"),
    MEDIA_TYPE_NOT_SUPPORTED(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "不支持当前媒体类型"),
    REQ_REJECT(HttpServletResponse.SC_FORBIDDEN, "请求被拒绝"),
    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "服务器异常"),
    PARAM_MISS(HttpServletResponse.SC_BAD_REQUEST, "缺少必要的请求参数"),
    PARAM_TYPE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "请求参数类型错误"),
    PARAM_BIND_ERROR(HttpServletResponse.SC_BAD_REQUEST, "请求参数绑定错误"),
    PARAM_VALID_ERROR(HttpServletResponse.SC_BAD_REQUEST, "参数校验失败"),

    /**10区*/
    ELSE(1000, "其他原因"),
    ILLEGAL_PARAM(1001, "参数错误"),
    PARAM_ABSENT(1002, "必填参数为空"),
    DB_EXCEPTION(1003, "数据库异常"),
    EXCEPTION(1004, "系统异常"),
    OBJECT_NOT_FIND(1005,"对象没有找到"),
    ILLEGAL_ARGUMENT(1006,"参数解析失败"),
    NOT_SUPPORT_METHOD(1007,"不支持当前请求方法"),
    NOT_PERMISSION(1008,"没有权限请求"),
    OBJECT_EXIST(1009,"对象已存在")

    ;

    /**
     * code编码
     */
    final int code;
    /**
     * 中文信息描述
     */
    final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
