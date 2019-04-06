package com.yuan.func;

public class Path {
    private final String path;

    private final String msg;

    private String str1;
    private String str2;

    private static final String template = "the path from %s to %s is:\n";

    public Path(){
        this.msg = "";
        this.path = "";
    }

    public Path(String str1,String str2){
        setStr(str1,str2);
        this.msg = String.format(template, str2, str1);
        this.path = WordLadder.get_path(str1, str2);
    }

    public String getPath(){
        if(this.path.charAt(0)=='#')
            return this.path;
        else
            return this.msg + this.path;
    }

    public void setStr(String str1,String str2){
        this.str1 = str1;
        this.str2 = str2;
    }
}
