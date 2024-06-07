package org.example;
import org.example.token;

import java.util.ArrayList;

//lisp词法分析器
public class lat {
    /*
     * 词法分析方法
     */
    public ArrayList<token> getTokenList(String input) {
        int length = input.length();
        int currentIndex = 0;
        ArrayList<token> tokenList = new ArrayList<token>();
        while (currentIndex < length) {
            char currentChar = input.charAt(currentIndex);
            //括号
            if (currentChar=='(' || currentChar==')'){
                //char to string
                StringBuilder sb = new StringBuilder();
                sb.append(currentChar);
                tokenList.add(new token("paren", sb.toString()));
                currentIndex++;
                continue;
            }
            //空格
            if (currentChar==' '){
                currentIndex++;
                continue;
            }
            //数字
            if (Character.isDigit(currentChar)){
                StringBuilder sb = new StringBuilder();
                while (currentIndex < length && Character.isDigit(input.charAt(currentIndex))){
                    sb.append(input.charAt(currentIndex));
                    currentIndex++;
                }
                tokenList.add(new token("number", sb.toString()));
                continue;
            }
            //字母
            if (Character.isLetter(currentChar)){
                StringBuilder sb = new StringBuilder();
                while (currentIndex < length && Character.isLetter(input.charAt(currentIndex))){
                    sb.append(input.charAt(currentIndex));
                    currentIndex++;
                }
                tokenList.add(new token("name", sb.toString()));
                continue;
            }
            //字符串
            if (currentChar=='"'){
                StringBuilder sb = new StringBuilder();
                currentIndex++;
                while (currentIndex < length && input.charAt(currentIndex)!='"'){
                    sb.append(input.charAt(currentIndex));
                    currentIndex++;
                }
                currentIndex++;
                tokenList.add(new token("string", sb.toString()));
                continue;
            }

            //tokenList.add(new token("other", currentChar+""));
            currentIndex++;
        }
        return tokenList;


    }
}
