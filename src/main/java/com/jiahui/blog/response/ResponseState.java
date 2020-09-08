package com.jiahui.blog.response;

public enum  ResponseState {
    SUCCESS(true,10000,"操作成功"),
    FAILED(false,10001,"操作失败");

    private boolean state;
    private int code;
    private String message;

    ResponseState(boolean state, int code, String message) {
        this.state = state;
        this.code = code;
        this.message = message;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
