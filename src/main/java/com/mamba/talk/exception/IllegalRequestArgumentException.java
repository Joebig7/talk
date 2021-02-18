package com.mamba.talk.exception;

/**
 * @Author JoeBig7
 * @date 2021/2/18 18:00:20
 */
public class IllegalRequestArgumentException extends RuntimeException {

    public IllegalRequestArgumentException() {
        super();
    }


    public IllegalRequestArgumentException(String message) {
        super(message);
    }
}
