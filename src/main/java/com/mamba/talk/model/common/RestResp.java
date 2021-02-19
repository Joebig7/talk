package com.mamba.talk.model.common;

/**
 * @Author JoeBig7
 * @date 2021/2/19 14:50:07
 */
public class RestResp {

    private static final String SUCCESS = "success";
    private static final Integer SUCCESS_CODE = 200;

    private Integer code;

    private String msg;

    private Object data;

    public RestResp() {
        this.msg = SUCCESS;
        this.code = SUCCESS_CODE;
    }

    public RestResp(String msg, Integer code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
