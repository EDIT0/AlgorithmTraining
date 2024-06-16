package com.my.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class s5_24313 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            // O(g(n)) = {f(n) | 모든 n ≥ n0에 대하여 f(n) ≤ c × g(n)인 양의 상수 c와 n0가 존재한다}
            // 함수 f(n) = a1n + a0, 양의 정수 c, n0가 주어질 경우 O(n) 정의를 만족하는지 알아보자.
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a0 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(br.readLine());
            int n0 = Integer.parseInt(br.readLine());

            // 함수 f(n) = a1n + a0, 양의 정수 c, n0가 주어질 경우 O(n) 정의를 만족하는지 알아보자.
            int fn = a1 * n0 + a0;
            int gn = n0;

            // a1*n + a0 <= cn
            // a0 <= cn - a1*n
            // a0 <= (c - a1)n
            // 이 조건이 성립하려면 c는 a1보다 무조건 같거나 커야한다.(-가 되면 안되므로) c>=a1
            if(fn <= c*gn && c>=a1) {
                bw.write("1");
            } else {
                bw.write("0");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
