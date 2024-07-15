package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_9012 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int T = Integer.parseInt(br.readLine());

            Stack<String> stringStack = new Stack<>();
            boolean isKey = false;
            for(int i=0;i<T;i++) {
                isKey = true;
                stringStack.clear();
                String input = br.readLine();

                if(input.length() % 2 != 0) {
                    bw.write("NO\n");
                    continue;
                }

                for(int j=0;j<input.length();j++) {
                    if(String.valueOf(input.charAt(j)).equals("(")) {
                        stringStack.add(String.valueOf(input.charAt(j)));
                    } else {
                        if(!stringStack.isEmpty()) {
                            stringStack.pop();
                        } else {
                            bw.write("NO\n");
                            isKey = false;  // 비어있는데 닫는 기호가 나오면 무조건 실패
                            break;
                        }
                    }
                }

                if(isKey) {
                    if(!stringStack.isEmpty()) {
                        bw.write("NO\n");
                    } else {
                        bw.write("YES\n");
                    }
                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
