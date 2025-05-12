package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 구현_b2_21918 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            ArrayList<Integer> stateList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0;i<N;i++) {
                int state = Integer.parseInt(st.nextToken());
                stateList.add(state);
            }

            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                b -= 1;
                c -= 1;

                switch (a) {
                    case 1: {
                        c += 1;
                        stateList = check1(stateList, b, c);
                        break;
                    }
                    case 2: {
                        stateList = check2(stateList, b, c);
                        break;
                    }
                    case 3: {
                        stateList = check3(stateList, b, c);
                        break;
                    }
                    case 4: {
                        stateList = check4(stateList, b, c);
                        break;
                    }
                    default: {

                    }
                }
            }

            for(int i=0;i<stateList.size();i++) {
                bw.write(stateList.get(i) + " ");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Integer> check1(ArrayList<Integer> stateList, int i, int x) {
        stateList.set(i, x);
        return stateList;
    }

    public static ArrayList<Integer> check2(ArrayList<Integer> stateList, int l, int r) {
        for(int i=l;i<=r;i++) {
            if(stateList.get(i) == 0) {
                stateList.set(i, 1);
            } else {
                stateList.set(i, 0);
            }
        }
        return stateList;
    }

    public static ArrayList<Integer> check3(ArrayList<Integer> stateList, int l, int r) {
        for(int i=l;i<=r;i++) {
            stateList.set(i, 0);
        }
        return stateList;
    }

    public static ArrayList<Integer> check4(ArrayList<Integer> stateList, int l, int r) {
        for(int i=l;i<=r;i++) {
            stateList.set(i, 1);
        }
        return stateList;
    }
}
