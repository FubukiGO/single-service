package com.ygg.baba.common.exception;

/**
 * @author akhan
 * @description 账号已锁定
 * @date 4:25 PM 2018/11/13
 */
public class AccountLockedExeption extends RuntimeException {
    public AccountLockedExeption(String msg) {
        super(msg);
    }
}
