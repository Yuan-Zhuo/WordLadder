package com.yuan.func;

public class WordLadderException extends RuntimeException {
    private String retCd;
    private String msgDes;

    public WordLadderException() {
        super();
    }

    public WordLadderException(String message) {
        super(message);
        msgDes = message;
    }

    public WordLadderException(String retCd, String msgDes) {
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