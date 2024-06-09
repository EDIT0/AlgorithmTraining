package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1_9506 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        * n이 완전수라면, n을 n이 아닌 약수들의 합으로 나타내어 출력한다(예제 출력 참고).
        * 이때, 약수들은 오름차순으로 나열해야 한다.
        * n이 완전수가 아니라면 n is NOT perfect. 를 출력한다.
        * 6 = 1 + 2 + 3
        * 12 is NOT perfect.
        * 28 = 1 + 2 + 4 + 7 + 14
        * */

        try {
            while (true) {
                int input = Integer.parseInt(br.readLine());
                if(input == -1) {
                    break;
                }

                int sum = 0; // 약수들의 합
                int[] arr = new int[input]; // 약수들을 담은 배열
                int idx = 0;

                for(int i=0;i<input;i++) {
                    if(i == input - 1) { // 입력 받은 숫자는 포함되지 않도록
                        continue;
                    }
                    int j = (input % (i+1));
                    if(j == 0) { // 0이면 sum과 arr에 담는다.
                        sum += (i+1);
                        arr[idx] = (i+1);
                        idx++;
                    }
                }

                if(sum == input) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("" + input + " = ");
                    for(int i=0;i<idx;i++) {
                        sb.append(arr[i]);
                        if(i != idx - 1) {
                            sb.append(" + ");
                        }
                    }
                    bw.write(sb.toString());
                } else {
                    bw.write("" + input + " is NOT perfect.");
                }

                bw.write("\n");

            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
