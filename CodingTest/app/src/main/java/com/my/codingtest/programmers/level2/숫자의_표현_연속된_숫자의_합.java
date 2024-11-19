package com.my.codingtest.programmers.level2;

public class 숫자의_표현_연속된_숫자의_합 {

    public static void main(String[] args) {
        int n1 = 15;

        System.out.println(solution(n1));
    }

    public static int solution(int n) {
        int answer = 0;

        // 연속된 자연수 합 공식
        // a: 더하기 시작하는 숫자, k: 갯수 n = 총합
        // n = k/2 * (2a + k - 1)
        // n = ka + k(k-1)/2, (n-(k(k-1)/2))/k = a
        for(int i=1;i<=n;i++) {
            int num = n - (i * (i-1)) / 2;
            if(num > 0) {
                if(num%i == 0) {
                    answer += 1;
                }
            } else {
                break;
            }
        }

        // 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다
//        for(int i=1;i<=n;i++) {
//            if(n%i==0) {
//                answer += 1;
//            }
//        }

        return answer;
    }
    
}
