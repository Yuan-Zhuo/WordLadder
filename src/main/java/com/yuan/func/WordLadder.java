package com.yuan.func;

import java.util.*;
import java.io.*;

public class WordLadder {
    private static Set<String> get_dict() {
        Set<String> dict=new HashSet<String>();
        try {
            Scanner file = new Scanner(new File("src/data/dict.txt"));
            while (file.hasNextLine())
                dict.add(file.nextLine());
            file.close();
        } catch (FileNotFoundException e) {
            throw new WordLadderException("#read error");
        }
        return dict;
    }

    private static String get_change(String str,int pos,int num){
        StringBuilder nextStr=new StringBuilder(str.substring(0,pos));
        nextStr.append((char)('a'+num));
        nextStr.append(str.substring(pos+1));
        return nextStr.toString();
    }

    private static Stack<String> get_stack(Set<String> dict,String str1,String str2){
        Stack<String> current=new Stack<String>();
        Queue<Stack<String>> q= new LinkedList<>();
        String nowStr,nextStr;
        Set<String> paths=new HashSet<String>();
        int n=str1.length();
        current.push(str1);

        q.offer(current);

        if(str1.equals(str2))
            return current;

        while(!q.isEmpty()){
            current=q.poll();
            nowStr=current.peek();

            for (int i = 0; i < n; ++i){
                for (int j = 0; j < 26; ++j){
                    if(j==(int)(nowStr.charAt(i)-'a'))
                        continue;

                    nextStr = get_change(nowStr, i, j);

                    if (dict.contains(nextStr) && !paths.contains(nextStr)){
                        current.push(nextStr);
                        if(nextStr.equals(str2)){
                            return current;
                        }
                        else{
                            paths.add(nextStr);
                            Stack<String> cpy=new Stack<String>();
                            cpy.addAll(current);
                            q.offer(cpy);
                        }
                        current.pop();
                    }
                }
            }
        }

        return new Stack<String>();
    }

    private static String check_str(Set<String> dict,String str1,String str2){
        if(!dict.contains(str1))
            return "#word1 error";
        else if(!dict.contains(str2))
            return "#word2 error";
        else if(str1.length()!=str2.length())
            return "#length error";
        else
            return "";
    }

    private static String display(Stack<String> path,String str1,String str2){
        if(path.isEmpty()){
            return "#no path";
        }else{
            StringBuilder strPath=new StringBuilder();
            while(!path.isEmpty())
                strPath.append(path.pop()+"\t");
            strPath.deleteCharAt(strPath.length()-1);
            return strPath.toString();
        }
    }

    public static String get_path(String str1,String str2) {
        Set<String> dict = get_dict();
        if(dict.isEmpty())
            return "#dictionary error";

        String msg=check_str(dict,str1,str2);
        Stack<String> path;
        if(msg.equals(""))
            path = get_stack(dict,str1,str2);
        else
            return msg;

        return display(path,str1,str2);
    }

    public static void main(String[] args) {
        System.out.println(get_path("cat","dog"));
    }
}