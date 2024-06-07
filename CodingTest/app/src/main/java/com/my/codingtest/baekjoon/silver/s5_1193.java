package com.my.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class s5_1193 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int X = Integer.parseInt(br.readLine());

            int prev_sum = 0; // 대각선 기준 현재 단계 이전까지의 합 (몇 번째인지?)
            int current_step = 1; // 대각선 기준 현재 단계
            String result = "";

            while (true) {
                if(X <= prev_sum + current_step) {
                    // current_step이 짝수면 분자가 큰 수 부터
                    // current_step이 홀수면 분자가 작은 수 부터
                    if(current_step % 2 == 0) {
                        // 찾고자 하는 X번째 - 이전까지의 합을 빼면 현재 단계에 대한 분모 숫자를 얻을 수 있다.
                        result = (X - prev_sum) + "/" + (current_step - (X - prev_sum) + 1);
                        break;
                    } else {
                        result = (current_step - (X - prev_sum) + 1) + "/" + (X - prev_sum);
                        break;
                    }
                    // 짝수일 경우 2/3
                    // current_step - (X - prev_sum) + 1 -> 분자
                    // X - prev_sum -> 분모
                    // 홀수일 경우 4/2
                    // X - prev_sum -> 분자
                    // current_step - (X - prev_sum) + 1 -> 분모
                } else {
                    prev_sum += current_step;
                    current_step++;
                }
            }

            bw.write(result);

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }
}
