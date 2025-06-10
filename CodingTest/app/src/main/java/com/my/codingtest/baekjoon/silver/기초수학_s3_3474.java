package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 기초수학_s3_3474 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            long N = Integer.parseInt(br.readLine());

            // 10으로 나눠져야 하므로 2 * 5
            // N!을 소인수분해하면 2가 당연히 많이 나오기 때문에 5 갯수를 구해서 2랑 매칭하여 10 만들어주면 그게 뒷자리 0의 갯수
            long sum = 0;
            double index = 1;
            while (true) {
                long cal = (long) (N / Math.pow(5, index));
                if(cal == 0) {
                    break;
                }
                sum += cal;
                index += 1;
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
