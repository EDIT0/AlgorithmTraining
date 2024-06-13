package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b3_14215 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            ArrayList<Integer> arrList = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = 0;

            arrList.add(Integer.parseInt(st.nextToken()));
            arrList.add(Integer.parseInt(st.nextToken()));
            arrList.add(Integer.parseInt(st.nextToken()));

            Collections.sort(arrList);

            if((arrList.get(0) + arrList.get(1)) > arrList.get(2)) {
                result = arrList.get(0) + arrList.get(1) + arrList.get(2);
            } else {
                int z = arrList.get(0) + arrList.get(1) - 1;
                result = z + arrList.get(0) + arrList.get(1);
            }

            bw.write(result + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
