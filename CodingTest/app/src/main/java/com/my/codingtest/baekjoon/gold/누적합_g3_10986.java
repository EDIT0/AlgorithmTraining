package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 누적합_g3_10986 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        long[] prefix = new long[N+1];
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        map.put(0, 1);
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = arr[i] + prefix[i-1];
            long r = prefix[i] % M; // 누적합에서 M으로 나눈 값
            r = (r + M) % M;  // 음수 처리
            map.put((int) r, map.getOrDefault((int)r, 0) + 1);
        }

        // K(K-1)/2 -> K개에서 2개를 고르는 경우의 수
        long answer = 0;
        for(int i=0;i<M;i++) {
            int remainder = map.getOrDefault(i, -1);
            if(remainder == -1) {
                continue;
            }
            answer += ((long) remainder * (remainder - 1) / 2);
        }

//        int answer = 0;
//
//        for(int i=1;i<=N;i++) {
//            for(int j=1;j<=N;j++) {
//                int sum = prefix[j] - prefix[i-1];
//                System.out.println(sum + " / " + ((sum % M) == 0));
//                if(sum <= 0) {
//                    continue;
//                }
//                boolean is = ((sum % M) == 0);
//                if(is) {
//                    answer += 1;
//                }
//            }
//        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
