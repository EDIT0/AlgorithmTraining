package com.my.codingtest.programmers.level1;

import java.util.Stack;

public class 크레인_인형뽑기_게임_KAKAO {
    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {1,5,3,5,1,2,1,4};
        // 4 -> 4,3,1,1,3,2,4

        System.out.println(solution(board, moves) + "");
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<moves.length;i++) {
            int pick = moves[i];

            for(int j=0;j<board.length;j++) {
                int find = board[j][pick-1];
                if(find != 0) {
                    board[j][pick-1] = 0;

                    if(!stack.isEmpty() && stack.peek() == find) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(find);
                    }

                    break;
                }
            }
        }

        return answer;
    }
}
