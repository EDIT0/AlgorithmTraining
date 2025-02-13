package com.my.codingtest.programmers.level2;

public class 점프와_순간이동 {

    public static void main(String[] args) {
        int n1 = 5;
        // 2;

        int n2 = 6;
        // 2;

        int n3 = 5000;
        // 5

        System.out.println(solution(n3) + "");
    }

    public static int solution(int n) {
        int ans = 0;

        while (true) {
            if(n == 0) {
                break;
            }
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans += 1;
            }
        }

        return ans;
    }

}
