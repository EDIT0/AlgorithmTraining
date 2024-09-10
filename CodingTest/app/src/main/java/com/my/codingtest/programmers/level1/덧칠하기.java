package com.my.codingtest.programmers.level1;

public class 덧칠하기 {

    public static void main(String[] args) {
        int n1 = 8;
        int m1 = 4;
        int[] section1 = { 2, 3, 6 };

        int n2 = 5;
        int m2 = 4;
        int[] section2 = {1, 3};

        int n3 = 4;
        int m3 = 1;
        int[] section3 = {1,2,3,4};

        System.out.println(solution(n3, m3, section3) + "");
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;

        int current = 0;
        int count = 0;
        for(int i=0;i<section.length;i++) {
            int e = section[i]; // 칠해야하는 곳
            if(current < e) {
                current = e + m -1; // 한 번에 current까지 칠하기 가능
                count += 1;
            }
        }

        answer = count;

        return answer;
    }

}
