package com.my.codingtest.baekjoon.bronze;

import java.io.*;

public class b2_2231 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int result = 0;

            for(int i=1;i<=N;i++) {
                int num = i;
                String strN = String.valueOf(i);
                int sum = 0;
                while(num > 0){
                    sum += num%10;
                    num /= 10;
                }
//                for(int j=0;j<strN.length();j++) {
//                    sum += Integer.parseInt(String.valueOf(strN.charAt(j))); // 각 자리 수를 더한다.
//                }
                if((sum + i) == N) { // 각 자리 수를 더한 값과 본 값(생성자)을 더하여 N과 같으면 정답
                    result = i;
                    break;
                }
            }

            bw.write(result + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
