package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// DFS, 완전 탐색
public class 구현_백트랙킹_s2_1182 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;
    public static int N, S;
    public static int[] arr;

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(S == 0) {
            answer -= 1;
        }


        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 
     * 현재 상황: index번째 원소를 보고 있음, 지금까지 합은 sum
     *
     * 선택 1: 이 원소를 포함한다면?
     * → 다음 원소로 넘어가고, 합에 현재 원소를 더함
     * → dfs(index + 1, sum + arr[index])
     *
     * 선택 2: 이 원소를 포함하지 않는다면?
     * → 다음 원소로 넘어가고, 합은 그대로
     * → dfs(index + 1, sum)
     */
    public static void dfs(int index, int sum) {
        if(index == N) {
            if(sum == S) {
                System.out.println("같음 - " + answer);
                answer += 1;
            }
            System.out.println("끝");
            return;
        }

        System.out.println(index + " / " + sum);
        dfs(index + 1, sum + arr[index]);

        dfs(index + 1, sum);
    }
}
