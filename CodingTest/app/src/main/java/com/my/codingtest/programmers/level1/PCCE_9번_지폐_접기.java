package com.my.codingtest.programmers.level1;

public class PCCE_9번_지폐_접기 {
    public static void main(String[] args) {
        int[] wallet1 = {30, 15};
        int[] bill1 = {26, 27};

        int[] wallet2 = {50, 50};
        int[] bill2 = {100, 241};


        System.out.println(solution(wallet1, bill1) + "");
    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
                break;
            } else {
                if(bill[0] >= bill[1]) {
                    bill[0] /= 2;
                } else {
                    bill[1] /= 2;
                }

                answer += 1;

                // 90 접힌서 들어가는지 확인
                if(wallet[0] >= bill[1] && wallet[1] >= bill[0]) {
                    break;
                }
            }
        }

        return answer;
    }
}
