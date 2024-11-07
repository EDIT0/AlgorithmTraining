package com.my.codingtest.programmers.level2;

public class 두_원_사이의_정수_쌍 {

    public static void main(String[] args) {
        int r1 = 999999;
        int r2 = 1000000;
//        int r1 = 9009;
//        int r2 = 1000000;
//        int r1 = 2;
//        int r2 = 4;

        System.out.println(solution(r1, r2));
        System.out.println("다른 사람 풀이: " + solution1(r1, r2));
        System.out.println("내 풀이: " + solution2(r1, r2));
    }

    public static long solution(int r1, int r2) {
        long answer = 0;

        long sum = 0;

        // (1,1) 부터 시작
        for(int i=1;i<=r2;i++) {
            long value1 = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));
            // 2^2 - 1^2 = 루트3 -> 2
            // 2^2 - 2^2 = 0
            // 2^2 - 2^3 = ?
            long value2 = (long) Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            // 3^2 - 1^2 = 루트8 -> 2
            // 3^2 - 2^2 = 루트5 -> 2
            // 3^2 - 3^2 = 0
//            System.out.println(value2 + "/" + value1);
            sum += ((value2 - value1) + 1);
        }
//        System.out.println(sum * 4);
        answer = sum * 4;

        return answer;
    }

    // 다른 사람 풀이
    public static long solution1(int r1, int r2) {
        long answer = 0;
        for (int y = 1; y <= r2; y++) { // (1)
            int x2 = (int) Math.sqrt(Math.pow(r2, 2) - Math.pow(y, 2)); // (2)
            int x1 = (int) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(y, 2))); // (3)
            answer += x2 - x1 + 1; // (4)
        }
        return answer * 4;
    }

    // 내 풀이
    public static long solution2(int r1, int r2) {
        long answer = 0;

        long sumR1 = 0;
        long sumR2 = 0;

        // (1,1) 부터 시작 (1사분면만 계산)
        for(int i=1;i<=r1;i++) {
            double value = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
            if(value % 1 == 0) {
                sumR1 += ((long) value); // 좌표 점에 딱 맞아 떨어져서 큰 원 합에서 빼면 안된다. (갯수에 포함되어야 하니까)
            } else {
                sumR1 += ((long) value+1);
            }
        }
        // (1,1) 부터 시작 (1사분면만 계산)
        for(int i=1;i<=r2;i++) {
            double value = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            if(value % 1 == 0) {
                sumR2 += ((long) value+1);
            } else {
                sumR2 += ((long) value+1);
            }
        }
        answer = ((sumR2-sumR1) * 4);

        return answer;
    }
}
