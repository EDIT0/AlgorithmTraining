package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1_2869 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 하루에 올라가는 높이
            int B = Integer.parseInt(st.nextToken()); // 하루에 떨어지는 높이
            int V = Integer.parseInt(st.nextToken()); // 총 도달해야하는 높이

            int current_step = 0; // 현재 높이
            int repeat_count = 1; // 반복 횟수 (며칠이 지났는지)

            // 2 1 5 -> 4
            // 5 1 6 -> 2
            // 100 99 1000000000 -> 999999901
            // 7 3 20 -> 5

            // 마지막은 자다가 떨어지지 않으므로 V(총 높이)에서 B(떨어지는 높이)를 뺀 상태에서 하루에 올라가는 높이(A-B)를 나눠준다.
            // 여기에서 소수점이 남는다면 더 올라가야 하므로 Day를 +1 해준다.
            double day = (double) (V - B) / (A - B);
            if(day != (int)day) {
                day += 1;
            }
            bw.write("" + (int) day);

//            int aa = A - B;
//            int bb = V - B;
//            int cc = bb / aa;
//            int dd = bb % aa;
//            if(dd != 0) {
//                int result = cc + 1;
//                bw.write("" + result);
//            } else {
//                int result = cc;
//                bw.write("" + result);
//            }

//            while (true) {
//                current_step += A; // 하루에 올라갈 수 있는 만큼 올라간다.
//                if(current_step >= V) { // 도달 여부 확인
//                    break;
//                } else { // 도달하지 못했으면 B만큼 떨어진다.
//                    current_step -= B;
//                }
//                repeat_count++;
//            }

//            bw.write("" + repeat_count);

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
