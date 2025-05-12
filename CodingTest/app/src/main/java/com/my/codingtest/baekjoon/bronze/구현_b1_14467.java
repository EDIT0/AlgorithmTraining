package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 구현_b1_14467 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            HashMap<String, String> hashMap = new HashMap<>();
            int count = 0;

            for(int i=1;i<=10;i++) {
                hashMap.put(i+"", "");
            }

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String cowName = st.nextToken();
                String location = st.nextToken();
                if(!hashMap.get(cowName).equals("")) {
                    if(!hashMap.get(cowName).equals(location)) {
                        count += 1;
                    }
                }
                hashMap.put(cowName, location);
            }

            bw.write(count + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
