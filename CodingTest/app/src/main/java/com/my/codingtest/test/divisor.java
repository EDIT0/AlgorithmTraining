package com.my.codingtest.test;

import java.util.ArrayList;
import java.util.Scanner;

public class divisor {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        System.out.println(divisor1(N) + "");
    }

    public static ArrayList<Long> divisor1(long N) {
        ArrayList<Long> longList = new ArrayList<>();
        for(long i=1;i<N;i++) {
            if(N % i == 0) {
                longList.add(i);
            }
        }

        longList.add(N);

        return longList;
    }
}
