package com.xtl.exception;

/**
 * @author 31925
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
