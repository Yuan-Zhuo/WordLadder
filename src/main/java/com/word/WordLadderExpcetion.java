package com.word;

public class WordLadderExpcetion extends RuntimeException {

    private String retCd;
    private String msgDes;

    public WordLadderExpcetion() {
        super();
    }

    public WordLadderExpcetion(String message) {
        super(message);
        msgDes = message;
    }

    public WordLadderExpcetion(String retCd, String msgDes) {
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