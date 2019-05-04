package com.yuan.wordladder.func;

public class Exception extends RuntimeException {
    private String retCd;
    private String msgDes;

    public Exception() {
        super();
    }

    public Exception(String message) {
        super(message);
        msgDes = message;
    }

    public Exception(String retCd, String msgDes) {
        super();
        this.retCd = retCd;
        this.msgDes = msgDes;
    }

    public String getRetCd() {
        return retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }
}