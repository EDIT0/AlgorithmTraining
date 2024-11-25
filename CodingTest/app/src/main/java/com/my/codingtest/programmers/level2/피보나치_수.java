package com.my.codingtest.programmers.level2;

public class 피보나치_수 {

    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 5;
        int n3 = 100000;

        System.out.println(solution(n1));
    }

    public static int solution(int n) {
        int answer = 0;


        long fibonacciStart = System.currentTimeMillis();
        long result = fibonacci(n);
        System.out.println(result);
        long fibonacciEnd = System.currentTimeMillis();
        System.out.println("fibonacci(" + n + ") 결과: " + result + ", 실행 시간: " + (fibonacciEnd - fibonacciStart) + " ms");

        long dpArrayStart = System.currentTimeMillis();
        long result2 = dpArray(n);
        System.out.println(result2);
        long dpArrayEnd = System.currentTimeMillis();
        System.out.println("dpArray(" + n + ") 결과: " + result2 + ", 실행 시간: " + (dpArrayEnd - dpArrayStart) + " ms");

        long sumFiboStart = System.currentTimeMillis();
        long result3 = sumFibo(n, 1234567);
        System.out.println(result3);
        long sumFiboEnd = System.currentTimeMillis();
        System.out.println("sumFibo(" + n + ") 결과: " + result3 + ", 실행 시간: " + (sumFiboEnd - sumFiboStart) + " ms");

        answer = (int) result3;

        return answer;
    }

    public static long fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static long dpArray(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static long sumFibo(int n, int a) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        long num1 = 0;
        long num2 = 1;

        for(int i=2;i<=n;i++) {
            long current = (num1 + num2) % a;
            num1 = num2;
            num2 = current;
        }

        return num2;
    }

}
