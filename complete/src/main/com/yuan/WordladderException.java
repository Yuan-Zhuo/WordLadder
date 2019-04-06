package com.yuan;

public class WordladderException extends RuntimeException {
    private String retCd;
    private String msgDes;

    public WordladderException() {
        super();
    }

    public WordladderException(String message) {
        super(message);
        msgDes = message;
    }

    public WordladderException(String retCd, String msgDes) {
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
