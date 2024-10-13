package com.my.codingtest.programmers.level1;

public class 약수의_개수와_덧셈 {
    public static void main(String[] args) {
        int left1 = 13;
        int right1 = 17;
        // 43

        int left2 = 24;
        int right2 = 27;
        // 52

        System.out.println(solution(left2, right2) + "");
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for(int i=left;i<=right;i++) {
            int count = 0;
            for(int j=1;j<=i;j++) {
                if(i%j == 0) {
                    count += 1;
                }
            }
            if(count%2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        // 약수의 개수가 홀수인지 짝수인지 알 수 있는 방법
//        for (int i=left;i<=right;i++) {
//            // 제곱수인 경우 약수의 개수가 홀수
//            if (i % Math.sqrt(i) == 0) {
//                answer -= i;
//            }
//            // 제곱수가 아닌 경우 약수의 개수가 짝수
//            else {
//                answer += i;
//            }
//        }

        return answer;
    }
}
