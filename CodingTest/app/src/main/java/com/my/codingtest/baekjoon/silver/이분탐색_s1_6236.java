package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 이분탐색_s1_6236 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        /**
         * 현우는 앞으로 N일 동안 자신이 사용할 금액을 계산하였고, 돈을 펑펑 쓰지 않기 위해 정확히 M번만 통장에서 돈을 빼서 쓰기로 하였다.
         * 현우는 통장에서 K원을 인출하며, 통장에서 뺀 돈으로 하루를 보낼 수 있으면 그대로 사용하고, 모자라게 되면 남은 금액은 통장에 집어넣고 다시 K원을 인출한다.
         * 다만 현우는 M이라는 숫자를 좋아하기 때문에, 정확히 M번을 맞추기 위해서 남은 금액이 그날 사용할 금액보다 많더라도 남은 금액은 통장에 집어넣고 다시 K원을 인출할 수 있다.
         * 현우는 돈을 아끼기 위해 인출 금액 K를 최소화하기로 하였다.
         * 현우가 필요한 최소 금액 K를 계산하는 프로그램을 작성하시오.
         *
         * 7 5
         * a
         * 100
         * 400
         * a
         * 300
         * 100
         * a
         * 500
         * a
         * 101
         * a
         * 400
         * */
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = binary(arr, M);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

    public static int binary(int[] arr, int M) {
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int returnValue = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
//            System.out.println("mid : " + mid);

            int wallet = mid;
            int count = 1;
            for(int i=0;i<arr.length;i++) {
                if(wallet - arr[i] >= 0) {
                    wallet -= arr[i];
                } else {
                    wallet = mid;
                    wallet -= arr[i];
                    count += 1;
                }
            }

//            System.out.println("count : " + count);

            if(count <= M) {
                high = mid - 1;
                returnValue = mid;
            } else if(count > M) {
                low = mid + 1;
            }
        }

        return returnValue;
    }
}
