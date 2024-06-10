package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b2_1978 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int result = 0; // 소수 개수

            for(int i=0;i<N;i++) {
                int input = Integer.parseInt(st.nextToken()); // 각 숫자 뽑기
                if(input == 1) { // 1이면 할 필요 없으므로 패스 (1은 소수가 아니므로)
                    continue;
                }
                int sum = 0;
                for(int j=0;j<input-1;j++) { // input 숫자를 제외하고 약수를 구해서 sum에 합친다.
                    int k = input % (j+1);
                    if(k == 0) {
                        sum += (j+1);
                    }
                }
                if(sum == 1) { // sum이 1보다 크면 소수가 아니다.
                    result++;
                }
            }

            bw.write("" + result);

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }

    }
}
