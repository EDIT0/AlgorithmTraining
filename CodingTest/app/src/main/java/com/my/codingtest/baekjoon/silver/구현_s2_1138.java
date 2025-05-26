package com.my.codingtest.baekjoon.silver;

import java.util.*;
import java.io.*;

public class 구현_s2_1138 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] arr = new int[N];

            for(int i=1;i<=N;i++) {
                int count = Integer.parseInt(st.nextToken());
                int c = 0;

                for(int j=0;j<N;j++) {
                    if(arr[j] == 0) {
                        if(c == count) {
                            arr[j] = i;
                            break;
                        }
                        c += 1;
                    }
                }

//                if(arr[count] == 0) {
//                    arr[count] = num;
//                    num += 1;
//                } else {
//                    for(int j=0;j<arr.length;j++) {
//                        if(c == count) {
//                            if(arr[j] == 0) {
//                                arr[j] = num;
//                                num += 1;
//                                break;
//                            }
//                            continue;
//                        }
//                        if(arr[j] == 0 || arr[j] > num) {
//                            c += 1;
//                        }
//                    }
//                }
            }

            for(int i=0;i<arr.length;i++) {
                bw.write(arr[i] + " ");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
