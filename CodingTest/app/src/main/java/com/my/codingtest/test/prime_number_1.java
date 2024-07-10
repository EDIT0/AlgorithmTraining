package com.my.codingtest.test;

public class prime_number_1 {
    public static void main(String[] args) {
        for(int i=0;i<20;i++) {
            if(isPrimeNumber(i)) {
                System.out.println(i + "는 소수입니다.");
            } else {
                System.out.println(i + "는 소수가 아닙니다.");
            }
        }
    }

    public static boolean isPrimeNumber(int n) {
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;

        for(int i=4;i*i<=n;i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
