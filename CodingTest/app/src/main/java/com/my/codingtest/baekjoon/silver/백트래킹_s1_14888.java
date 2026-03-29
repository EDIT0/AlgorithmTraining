package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 백트래킹_s1_14888 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, plus, minus, multiple, divide;
    public static int maximum = Integer.MIN_VALUE;
    public static int minimum = Integer.MAX_VALUE;
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        // 숫자 받기
        st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[N];
        for(int i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 더하기, 빼기, 곱하기, 나누기 갯수 받기
        st = new StringTokenizer(br.readLine(), " ");
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multiple = Integer.parseInt(st.nextToken());
        divide = Integer.parseInt(st.nextToken());

        // numbers[0]이 첫번째 숫자, depth 1부터 시작
        dfs(1, numbers[0], plus, minus, multiple, divide);

        bw.write(maximum + "\n" + minimum);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int sum, int plus, int minus, int multiple, int divide) {
        if(depth == N) {
            if(maximum < sum) {
                maximum = sum;
            }
            if(minimum > sum) {
                minimum = sum;
            }
            return;
        }

        if(plus > 0) {
            dfs(depth + 1, sum + numbers[depth], plus - 1, minus, multiple, divide);
        }

        if(minus > 0) {
            dfs(depth + 1, sum - numbers[depth], plus, minus - 1, multiple, divide);
        }

        if(multiple > 0) {
            dfs(depth + 1, sum * numbers[depth], plus, minus, multiple - 1, divide);
        }

        if(divide > 0) {
            dfs(depth + 1, sum / numbers[depth], plus, minus, multiple, divide - 1);
        }
    }
}
