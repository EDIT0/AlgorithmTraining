package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s3_1735 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int A1 = Integer.parseInt(st.nextToken());
            int B1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int A2 = Integer.parseInt(st.nextToken());
            int B2 = Integer.parseInt(st.nextToken());


            int b = lcm(B1, B2); // 분모들의 최소 공배수를 구한다.
            int bb = b / B1;
            int bbb = b / B2;

//            bw.write(b + "/" + bb + "/" + bbb + "\n");

            int a1 = A1 * bb; // 기존 분모에 분모가 곱해진 만큼 곱해준다.
            int a2 = A2 * bbb; // 기존 분모에 분모가 곱해진 만큼 곱해준다.

//            bw.write(a1 + "/" + a2 + "\n");

            int a = a1 + a2; // 분자끼리 더한다.

//            bw.write(a + "/" + b + "\n");

            int tmp = gdc(a, b); // 기약분수가 아닐 수 있으므로 분자와 분모의 최대 공약수를 구한다.

            int resultA = a / tmp; // 분모를 최대 공약수로 나눈다.
            int resultB = b / tmp; // 분자를 최대 공약수로 나눈다.

            bw.write(resultA + " " + resultB);

            bw.flush();
            bw.close();
            br.close();


        } catch (Exception e) {

        }
    }

    // 최대 공약수
    public static int gdc(int a, int b) {
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    // 최소 공배수
    public static int lcm(int a, int b) {
        return a * b / gdc(a, b);
    }
}
