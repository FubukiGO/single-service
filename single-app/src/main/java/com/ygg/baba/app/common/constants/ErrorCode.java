package com.ygg.baba.app.common.constants;

public enum ErrorCode {

    //系统级
    SUCCESS(200, "操作成功"),
    FAIL(300, "操作失败"),
    LOGIN_ERROR(301, "登录失败"),
    //用户操作
    NOT_BING_PLAT(888, "未绑定平台"),
    PHONE_NULL(400, "手机号为空"),
    EMAIL_NULL(401, "邮箱为空"),
    PASSWORD_NULL(402, "请输入密码"),
    REPASSWORD_NULL(403, "请输入确认密码"),
    PASSWORD_NOT_SAME(403, "两次密码不一致"),
    RECHARGE_OFF(501, "充值功能被关闭，请联系客服"),
    RECHARGE_FAIL(502, "充值失败，请稍后再试"),
    WAIT_RECHARGE(503, "请输入验证码完成充值"),
    //项目
    PROJECT_NULL(1001, "项目不存在"),
    PLATFORM_NULL(1002, "平台用户不存在"),

    ;

    private Integer code;

    private String desc;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    //通过value获取对应的枚举对象
    public static ErrorCode getErrorCode(String key) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (key.equals(errorCode.getCode())) {
                return errorCode;
            }
        }
        return null;
    }
}
