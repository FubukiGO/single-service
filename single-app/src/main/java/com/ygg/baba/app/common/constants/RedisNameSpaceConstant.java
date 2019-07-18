package com.ygg.baba.app.common.constants;

/**
 * @author akhan
 * @description redis命名空间
 * @date 15:31 2018-11-23
 */
public interface RedisNameSpaceConstant {
    String LOGIN_ERROR_COUNT = "jwt_storage:";

    String TOKEN_STORAGE = "token_storage:";

    String IP_REGISTER_LIMIT = "ip_register_limit:";

    String USER_LOGIN_LOGS = "user_login_logs:";

    String CAPTCHA = "captcha:";
}
