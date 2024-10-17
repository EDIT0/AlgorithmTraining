package com.my.codingtest.programmers.level1;

public class 키패드_누르기_KAKAO {
    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand1 = "right";
        // LRLLLRLLRRL

        int[] number2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";
        // LRLLRRLLLRR

        int[] number3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "right";
        // LLRLLRLLRL

        System.out.println(solution(number3, hand3) + "");
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        int currentL = 10;
        int currentR = 12;

        for(int i=0;i<numbers.length;i++) {
            int num = numbers[i];

            // *, 0, # 도 10, 11, 12로 본다.
            if(num == 0) {
                num = 11;
            }

            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                currentL = num;
                continue;
            } else if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                currentR = num;
                continue;
            }

            int l = Math.abs(currentL-num);
            int r = Math.abs(currentR-num);

            int disL = 0;
            int disR = 0;

            // 거리 계산
            while (l > 0) {
                if(l >= 3) {
                    l -= 3;
                    disL += 1;
                } else {
                    if(l == 2) { // 2가 남으면 2번 이동
                        l -= 2;
                        disL += 2;
                    } else { // 1이 남으면 1번 이동
                        l -= 1;
                        disL += 1;
                    }
                }
            }

            while (r > 0) {
                if(r >= 3) {
                    r -= 3;
                    disR += 1;
                } else {
                    if(r == 2) {
                        r -= 2;
                        disR += 2;
                    } else {
                        r -= 1;
                        disR += 1;
                    }
                }
            }

            if(disR == disL) {
                if(hand.equals("right")) {
                    sb.append("R");
                    currentR = num;
                } else {
                    sb.append("L");
                    currentL = num;
                }
            } else if(disR > disL) {
                sb.append("L");
                currentL = num;
            } else {
                sb.append("R");
                currentR = num;
            }
        }

        answer = sb.toString();

        return answer;
    }
}
