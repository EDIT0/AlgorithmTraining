package com.my.codingtest.baekjoon.bronze;

import java.io.*;

public class 기초수학_b1_1110 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        String newN = String.valueOf(N);
        int cycle = 0;

        /**
         * 이런 방법도 있음
         * int n1 = N / 10;
         * int n2 = N % 10;
         * int sum = n1 + n2;
         * N = (n2 * 10) + (sum % 10);
         * */
        while (true) {
            cycle += 1;
            if(newN.length() == 1) {
                newN = "0" + newN;
            }

            int sum = 0;
            for(int i=0;i<newN.length();i++) {
                sum += Integer.parseInt(String.valueOf(newN.charAt(i)));
            }

            String strSum = String.valueOf(sum);

            String newNRight = String.valueOf(newN.charAt(newN.length()-1));
            String strSumRight = String.valueOf(strSum.charAt(strSum.length()-1));

            newN = newNRight + strSumRight;

            if(Integer.parseInt(newN) == N) {
                break;
            }
        }

        bw.write(cycle + "");

        bw.flush();
        bw.close();
        br.close();
    }

}
