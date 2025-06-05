package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 자료구조_g4_2800 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static String T = "";
    public static Stack<Integer> stack = new Stack<>();
    public static ArrayList<Pair> list = new ArrayList<>();
    public static Set<String> resultSet = new TreeSet<>();

    public static void main(String[] args) {

        try {
            T = br.readLine();

            for(int i=0;i<T.length();i++) {
                char c = T.charAt(i);

                if(c == '(') {
                    stack.add(i);
                } else if(c == ')'){
                    list.add(new Pair(stack.pop(), i));
                }
            }

            boolean[] isRemove = new boolean[list.size()];
            cal(0, isRemove);

            for(String s : resultSet) {
                bw.write(s + "\n");
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void cal(int index, boolean[] isRemove) {
        if(index == list.size()) {
            Set<Integer> removeSet = new HashSet<>();
            for(int i=0;i<isRemove.length;i++) {
                if(isRemove[i]) {
                    removeSet.add(list.get(i).first);
                    removeSet.add(list.get(i).second);
                }
            }

            if(removeSet.isEmpty()) {
                return;
            } else {
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<T.length();i++) {
                    if(removeSet.contains(i)) {

                    } else {
                        sb.append(T.charAt(i));
                    }
                }

                resultSet.add(sb.toString());
            }

            return;
        }

        isRemove[index] = false;
        cal(index + 1, isRemove);
        isRemove[index] = true;
        cal(index + 1, isRemove);
    }

    public static class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
