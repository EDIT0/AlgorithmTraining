package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_s1_14888 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[] arr;
    public static int N, plus, minus, multiple, divide;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multiple = Integer.parseInt(st.nextToken());
        divide = Integer.parseInt(st.nextToken());

        dfs(1, arr[0], plus, minus, multiple, divide);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int depth, int result, int plus, int minus, int multiple, int divide) {
        if(depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

//        System.out.println("1. " + plus +"/" + minus + "/" + multiple +"/" + divide);

        if(plus > 0) {
            dfs(depth + 1, result + arr[depth], plus - 1, minus, multiple, divide);
        }

//        System.out.println("2. " + plus +"/" + minus + "/" + multiple +"/" + divide);

        if(minus > 0) {
            dfs(depth + 1, result - arr[depth], plus, minus - 1, multiple, divide);
        }

//        System.out.println("3. " + plus +"/" + minus + "/" + multiple +"/" + divide);

        if(multiple > 0) {
            dfs(depth + 1, result * arr[depth], plus, minus, multiple - 1, divide);
        }

//        System.out.println("4. " + plus +"/" + minus + "/" + multiple +"/" + divide);

        if(divide > 0) {
            dfs(depth + 1, result / arr[depth], plus, minus, multiple, divide - 1);
        }

//        System.out.println("5. " + plus +"/" + minus + "/" + multiple +"/" + divide);
    }

}
