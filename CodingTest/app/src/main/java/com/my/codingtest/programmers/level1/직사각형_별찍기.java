package com.my.codingtest.programmers.level1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 직사각형_별찍기 {

    public static void main(String[] args) {

        System.out.println(solution() + "");
    }

    public static int solution() {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    bw.write("*");
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return answer;
    }

}
