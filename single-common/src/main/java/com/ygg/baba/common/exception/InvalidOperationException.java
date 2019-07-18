package com.ygg.baba.common.exception;

/**
 * @author akhan
 * @description
 * @date 15:39 2018-12-20
 */
public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException() {
        super("invalid operation");
    }
}
