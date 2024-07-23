package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s5_11866 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Boolean[] arr = new Boolean[N+1];
            ArrayList<Integer> arrList = new ArrayList<>();

            for(int i=1;i<=N;i++) {
                arr[i] = false;
            }

            int index = 1; // 3번째인지 확인
            int current = 1; // 현재 순번 가르킴
            while (true) {

                if(arr[current]) {
                    current++; // 이미 확정된 숫자이므로 index는 세지않고 current만 +1 한다.
                } else {
                    if(index % K == 0) { // K번째의 숫자
                        index = 1;
                        arr[current] = true;
                        arrList.add(current);
                        current++;
                    } else { // 확정된 숫자도 아니고 K번째 숫자도 아니므로 index, current 각 +1
                        index++;
                        current++;
                    }
                }

                if(current > arr.length - 1) {
                    current = 1;
                }
                if(arrList.size() == N) {
                    break;
                }
            }

            bw.write("<");
            for(int i=0;i<arrList.size();i++) {
                if(i == arrList.size() - 1) {
                    bw.write(arrList.get(i) + "");
                } else {
                    bw.write(arrList.get(i) + ", ");
                }
            }
            bw.write(">");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }
}
