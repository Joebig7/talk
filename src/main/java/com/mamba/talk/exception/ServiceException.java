package com.mamba.talk.exception;

/**
 * @Author JoeBig7
 * @date 2021/2/19 11:48:27
 */
public class ServiceException extends RuntimeException{

    public ServiceException(String message){
        super(message);
    }
}
