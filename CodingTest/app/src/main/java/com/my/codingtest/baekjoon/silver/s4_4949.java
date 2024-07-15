package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_4949 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            ArrayList<String> openList = new ArrayList<>();
            openList.add("(");
            openList.add("[");

            ArrayList<String> closeList = new ArrayList<>();
            closeList.add(")");
            closeList.add("]");

            Stack<String> stringStack = new Stack<>();
            boolean key;

            while (true) {
                String input = br.readLine();

                if(input.length() == 1 && input.equals(".")) {
                    break;
                }

                stringStack.clear();
                key = true;

                for(int i=0;i<input.length();i++) {
                    String tmp = String.valueOf(input.charAt(i));
                    if(openList.contains(tmp)) {
                        stringStack.push(tmp);
                    } else if(closeList.contains(tmp)) {
                        if(stringStack.isEmpty()) { // 비어있는데 닫는 기호가 나오면 무조건 실패
                            key = false;
                            break;
                        }
                        String strTmp = "";
                        if(tmp.equals(")")) {
                            strTmp = "(";
                        } else {
                            strTmp = "[";
                        }
                        if(!stringStack.isEmpty() && stringStack.peek().equals(strTmp)) { // 기호가 서로 맞으면 pop
                            stringStack.pop();
                        } else {
                            break;
                        }
                    }
                }

                if(key) {
                    if(stringStack.isEmpty()) {
                        bw.write("yes\n");
                    } else {
                        bw.write("no\n");
                    }
                } else {
                    bw.write("no\n");
                }

            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
