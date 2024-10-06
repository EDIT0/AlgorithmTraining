package com.my.codingtest.programmers.level1;

public class PCCE_9번_이웃한_칸 {
    public static void main(String[] args) {
        String[][] board1 = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h1 = 1;
        int w1 = 1;
        // 2

        String[][] board2 = {{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}};
        int h2 = 0;
        int w2 = 1;
        // 1

        System.out.println(solution(board2, h2, w2) + "");
    }

    public static int solution(String[][] board, int h, int w) {
        int answer = 0;

        int[] hArr = {0, 1, -1, 0};
        int[] wArr = {1, 0, 0, -1};

        for(int i=0;i<hArr.length;i++) {
            int check_h = h + hArr[i];
            int check_w = w + wArr[i];

            if(check_h >= 0 && check_w >= 0 && check_h < board.length && check_w < board.length) {
                if(board[h][w].equals(board[check_h][check_w])) {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
