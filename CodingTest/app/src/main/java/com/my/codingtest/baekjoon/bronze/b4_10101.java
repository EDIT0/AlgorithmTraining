package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b4_10101 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            int z = Integer.parseInt(br.readLine());

            if(x == 60 && y == 60 && z == 60) { // 세 각의 크기가 모두 60이면, Equilateral
                bw.write("Equilateral");
            } else if(x + y + z == 180 && calIsosceles(x, y, z)) { // 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
                bw.write("Isosceles");
            } else if(x + y + z == 180 && calScalene(x, y, z)) { // 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
                bw.write("Scalene");
            } else if(x + y + z != 180) { // 세 각의 합이 180이 아닌 경우에는 Error
                bw.write("Error");
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
}
