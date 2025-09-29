package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 이분탐색_g4_16434 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int attack = Integer.parseInt(st.nextToken());

        Model[] arr = new Model[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Model(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        long answer = binary(arr, attack);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

    public static long binary(Model[] arr, int attack) {
        long low = 1;
        long high = Long.MAX_VALUE / 2;
//        for(int i=0;i<arr.length;i++) {
//            if(arr[i].t == 1) {
//                low += arr[i].a;
//                high += (long) arr[i].a * arr[i].h;
//            }
//        }
        long returnValue = 0;

//        System.out.println(low + " / " + high);

        while (low <= high) {
            long mid = (low + high) / 2;

            long hp = mid;
            long ak = attack;
//            System.out.println("hp : " + hp);
            for(int i=0;i<arr.length;i++) {
                if(arr[i].t == 1) {
                    long attackCount = arr[i].h / ak;
                    if(arr[i].h % ak != 0) {
                        attackCount += 1;
                    }
                    long attackDamage = arr[i].a * (attackCount - 1);
                    hp -= attackDamage;

//                    System.out.println("깍임: " + hp);

                    // 체력부족 사망
                    if(hp <= 0) {
                        break;
                    }
                } else {
                    ak += arr[i].a;
                    hp += arr[i].h;
                    if(hp > mid) {
                        hp = mid;
                    }

//                    System.out.println("채움: " + hp);
                }
            }

//            System.out.println("count : " + count);

            if(hp > 0) {
                high = mid - 1;
                returnValue = mid;
            } else if(hp <= 0) {
                low = mid + 1;
            }
        }

        return returnValue;
    }

    public static class Model {
        int t, a, h;

        Model(int t, int a, int h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }
}
