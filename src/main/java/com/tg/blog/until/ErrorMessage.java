package com.tg.blog.until;

/**
 *
 */
public enum ErrorMessage {

    /**
     * 通用ERROR
     */
    SYS_ERROR(10000, "系统开小差了,稍后再试"),
    PARAM_ERROR(10001, "参数错误"),


    /**
     * user相关error.
     */
    SMSCODE_ERROR(30001, "短信验证码错误"),
    PHONE_EXIST(30002, "手机号已经存在"),
    USER_NEED_LOGIN(30003, "用户需要登录"),

    /**
     * 秒杀ERROR
     */
    STOCK_NOT_ENOUGH(20001, "库存不足！"),
    REPEAT_ORDER_ERROR(20002, "不能重复下单！"),
    SECKILL_NOT_START(20003, "秒杀活动还没开始！"),


    NO_JSON(-8887, "Json format error!"),
    NO_LOGIN(-9999, "Please login first!"),
    USER_NOT_EXISTS(-9998, "User does not exist!"),
    USER_NO_PERMISSION(-9997, "User does not have permission!"),
    LOGIN_ERROR(-9996, "Login error!"),
    LOGIN_ERROR_USERNAME_PASSWORD_ERROR(-9991, "Username or password error!"),
    LOGIN_ERROR_PASSWORD_ERROR(-9990, "Password error!"),
    ACCOUNT_DISABLE(-9989, "Account disable!"),
    SECKILL_RATE_LIMIT_ERROR(20007,"你被限流了，直接返回失败" ),
    SECKILL_FAILED(0000001,"秒杀失败" ),
    SECKILL_VALIDATE_ERROR(20006, "秒杀验证码校验失败"),
    SECKILL_USER_VISIT_LIMIT_ERROR(20007, "用户访问过于频繁"),
    REGIST_FAILD(789456, "该用户已存在"),
    NO_USER(339945, "用户不存在");


    private Integer code;
    private String message;

    ErrorMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public ErrorMessage setMessage(String message) {
        this.message = message;
        return this;
    }
}
