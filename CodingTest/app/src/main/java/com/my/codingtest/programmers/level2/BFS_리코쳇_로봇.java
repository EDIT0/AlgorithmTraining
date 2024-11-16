package com.my.codingtest.programmers.level2;

import java.util.*;

public class BFS_리코쳇_로봇 {

    public static void main(String[] args) {
        String[] board1 = {
                "...D..R",
                ".D.G...",
                "....D.D",
                "D....D.",
                "..D...."
        };
        // 7

        String[] board2 = {
                ".D.R", "....",
                ".G..", "...D"
        };
        // -1

        String[] board3 = {
                "..R",
                "...",
                "...",
                "..D",
                "DG.",
        };
        // 4

        System.out.println(solution(board1));
    }

    public static int solution(String[] board) {
        int answer = 0;

        int startXPoint = 0;
        int startYPoint = 0;
        boolean[][] visited = new boolean[board.length][board[0].length()];

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length();j++) {
                if(board[i].charAt(j) == 'R') {
                    // 시작 좌표 찾기
                    startXPoint = i;
                    startYPoint = j;
                }
            }
        }

        answer = bfs(startXPoint, startYPoint, board, visited);

        return answer;
    }

    public static int bfs(int startX, int startY, String[] board, boolean[][] visited) {
        Queue<Pointer> queue = new LinkedList<>();

        queue.add(new Pointer(startX, startY, 0));

        visited[startX][startY] = true;

        // 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Pointer pointer = queue.poll();

            if(board[pointer.x].charAt(pointer.y) == 'G') {
                // 답
                System.out.println("음,, " + pointer.count);
                return pointer.count;
            }

//            System.out.println("시작 " + pointer.x + " / " + pointer.y);

            for(int i=0;i<4;i++) {
                int currentX = pointer.x;
                int currentY = pointer.y;

                while (true) {
                    int moveX = currentX+dx[i];
                    int moveY = currentY+dy[i];

                    // 좌표가 배열 끝에 도달하였을 경우
                    if(moveX < 0 || moveX >= board.length || moveY < 0 || moveY >= board[0].length()) {
                        moveX = moveX-dx[i];
                        moveY = moveY-dy[i];
                        if(visited[moveX][moveY] || (pointer.x == moveX && pointer.y == moveY)) {
                            // 끝점까지 이동한 결과과 visited에 등록된 곳이거나 상,하,좌,우를 출발한 좌표와 같다면 queue에 넣지 않고 넘긴다.
                            break;
                        }
                        visited[moveX][moveY] = true;
                        queue.add(new Pointer(moveX, moveY, pointer.count + 1));
                        break;
                    }
                    // 좌표가 벽을 만났을 경우
                    if(board[moveX].charAt(moveY) == 'D') {
                        moveX = moveX-dx[i];
                        moveY = moveY-dy[i];
                        if(visited[moveX][moveY] || (pointer.x == moveX && pointer.y == moveY)) {
                            // 끝점까지 이동한 결과과 visited에 등록된 곳이거나 상,하,좌,우를 출발한 좌표와 같다면 queue에 넣지 않고 넘긴다.
                            break;
                        }
                        visited[moveX][moveY] = true;
                        queue.add(new Pointer(moveX, moveY, pointer.count + 1));
                        break;
                    }

                    // 좌표가 .을 만났을 경우
                    currentX = moveX;
                    currentY = moveY;
                }
            }
        }

        return -1;
    }

    public static class Pointer {
        int x;
        int y;
        int count;

        public Pointer(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
