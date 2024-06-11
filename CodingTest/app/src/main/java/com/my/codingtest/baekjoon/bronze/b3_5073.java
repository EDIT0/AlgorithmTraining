package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b3_5073 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;

            while (true) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                if(x == 0 && y == 0 && z == 0) {
                    break;
                }

                if(x == y && y == z && z == x) { // Equilateral :  세 변의 길이가 모두 같은 경우
                    bw.write("Equilateral");
                } else if(calInvalid(x, y, z)) { // Invalid 케이스
                    bw.write("Invalid");
                } else if(calIsosceles(x, y, z)) { // Isosceles : 두 변의 길이만 같은 경우
                    bw.write("Isosceles");
                } else if(calScalene(x, y, z)) { // Scalene : 세 변의 길이가 모두 다른 경우
                    bw.write("Scalene");
                }

                bw.write("\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    public static boolean calIsosceles(int x, int y, int z) {
        if(x == y) {
            return true;
        }
        if(y == z) {
            return true;
        }
        if(z == x) {
            return true;
        }

        return false;
    }

    public static boolean calScalene(int x, int y, int z) {
        if(x != y && x != z && y != z) {
            return true;
        }

        return false;
    }

    public static boolean calInvalid(int x, int y, int z) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        if(max < x) {
            max = x;
        }

        if(max < y) {
            max = y;
            sum += x;
        } else {
            sum += y;
        }

        if(max < z) {
            max = z;
            sum += y;
        } else {
            sum += z;
        }

        return max >= sum;
    }
}
