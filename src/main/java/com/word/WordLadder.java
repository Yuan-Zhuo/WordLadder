package com.word;

import java.util.*;
import java.io.*;

public class WordLadder {
    private static Set<String> get_dict() {
        Set<String> dict=new HashSet<String>();
        try {
            Scanner file = new Scanner(new File("src/bin/dict.txt"));
            while (file.hasNextLine())
                dict.add(file.nextLine());
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the file dict.txt doesn't exist.");
            e.printStackTrace();
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

    private static boolean check_str(Set<String> dict,String str1,String str2){
        if(!dict.contains(str1))
            System.out.println("Sorry, the word "+str1+" isn't exist in our dict");
        else if(!dict.contains(str2))
            System.out.println("Sorry, the word "+str1+" isn't exist in our dict");
        else if(str1.length()!=str2.length())
            System.out.println("Please input two words with the same length!");
        else
            return true;

        return false;
    }

    private static String display(Stack<String> path,String str1,String str2){
        if(path.isEmpty()){
            return "no path";
        }else{
            StringBuilder strPath=new StringBuilder();
            while(!path.isEmpty())
                strPath.append(path.pop()+" ");
            strPath.deleteCharAt(strPath.length()-1);
            return strPath.toString();
        }
    }

    public static String get_path(String str1,String str2) {
        Set<String> dict = get_dict();
        if(check_str(dict,str1,str2)){
            Stack<String> path = get_stack(dict,str1,str2);
            return display(path,str1,str2);
        }else{
            return "words error";
        }
    }

    public static void main(String[] args){
        System.out.println(get_path("cat","dog"));
    }
}

