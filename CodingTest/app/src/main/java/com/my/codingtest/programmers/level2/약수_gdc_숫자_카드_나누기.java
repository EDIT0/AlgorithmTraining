package com.my.codingtest.programmers.level2;

import java.util.*;

public class 약수_gdc_숫자_카드_나누기 {

    public static void main(String[] args) {
        int[] arrayA1 = {10, 17};
        int[] arrayB1 = {5, 20};
        // 0

        int[] arrayA2 = {10, 20};
        int[] arrayB2 = {5, 17};
        // 10

        int[] arrayA3 = {14, 35, 119};
        int[] arrayB3 = {18, 30, 102};
        // 7

        int[] arrayA4 = {30, 20, 12};
        int[] arrayB4 = {7, 9, 19};
        // 2

        System.out.println(solution(arrayA1, arrayB1));
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Integer[] aArr = new Integer[arrayA.length];
        Integer[] bArr = new Integer[arrayB.length];

        for(int i=0;i<arrayA.length;i++) {
            aArr[i] = arrayA[i];
            bArr[i] = arrayB[i];
        }
        Arrays.sort(aArr);
        Arrays.sort(bArr, (o1, o2) -> {
            return o1 - o2;
        });

        int minANum = aArr[0];
        int minBNum = bArr[0];

        for(int i=1;i<aArr.length;i++) {
//            System.out.println("1. " + gdc(minANum, aArr[i]));
            minANum = (int) gdc(minANum, aArr[i]);

//            System.out.println("2. " + gdc(minBNum, bArr[i]));
            minBNum = (int) gdc(minBNum, bArr[i]);
        }

//        System.out.println(minANum + " / " + minBNum);

        ArrayList<Long> a = divisor(minANum);
        ArrayList<Long> b = divisor(minBNum);
        Collections.sort(a, Collections.reverseOrder());
        Collections.sort(b, Collections.reverseOrder());

        minANum = 0;
        minBNum = 0;

        // 최대공약수의 약수만큼 반복
        for(int i=0;i<a.size();i++) {
            if(canDivide(a.get(i), bArr)) {
                continue;
            } else {
                minANum = Integer.parseInt(String.valueOf(a.get(i)));
                break;
            }
        }

        // 최대공약수의 약수만큼 반복
        for(int i=0;i<b.size();i++) {
            if(canDivide(b.get(i), aArr)) {
                continue;
            } else {
                minBNum = Integer.parseInt(String.valueOf(b.get(i)));
                break;
            }
        }

        if(minANum > minBNum) {
            answer = minANum;
        } else {
            answer = minBNum;
        }

        return answer;
    }

    // 최대 공약수
    public static long gdc(long a, long b) {
        if(a < b) { // 유클리드 호제법 조건
            long tmp = a;
            a = b;
            b = tmp;
        }
        while(b != 0) { // 유클리드 호제법
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 약수 구하기
    public static ArrayList<Long> divisor(long n) {
        int sqrt = (int) Math.sqrt(n); // 100의 제곱근은 10
        ArrayList<Long> arr = new ArrayList<>(); // 약수 받을 ArrayList

        for(long i=1;i<=sqrt;i++){
            if(n%i == 0){ // 약수 중 작은 수 저장
                arr.add(i);
                if(n/i!=i){ // 약수 중 큰 수 저장
                    arr.add((n/i));
                }
            }
        }

        return arr;
    }

    // 나눌 수 있는지?
    public static boolean canDivide(long num, Integer[] arr) {
        if(num == 1) {
            return true;
        }
        for(int i=0;i<arr.length;i++) {
            if(arr[i]%num == 0) {
                return true;
            }
        }
        return false;
    }

}
