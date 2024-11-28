package com.my.codingtest.programmers.level2;

import java.util.*;

public class 무인도_여행 {

    public static void main(String[] args) {
        String[] maps1 = {
                "X591X",
                "X1X5X",
                "X231X",
                "1XXX1"
        };
        // 1,1,27
        String[] maps2 = {
                "XXX",
                "XXX",
                "XXX"
        };
        // -1

        System.out.println(Arrays.toString(solution(maps1)));
    }

    public static boolean[][] visited;

    public static int[] solution(String[] maps) {
        int[] answer = {};

        visited = new boolean[maps.length][maps[0].length()];

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<maps.length;i++) {
            for(int j=0;j<maps[i].length();j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    System.out.println("진입: " + i + " / " + j);
                    result.add(bfs(i, j, maps));
                }
            }
        }

        if(result.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[result.size()];

            for(int i=0;i<result.size();i++) {
                answer[i] = result.get(i);
            }

            Arrays.sort(answer);
        }

        return answer;
    }

    public static int bfs(int startX, int startY, String[] maps) {
        Queue<Pointer> queue = new LinkedList();

        int sum = 0;
        queue.add(new Pointer(startX, startY));
        sum += Integer.parseInt(String.valueOf(maps[startX].charAt(startY)));
        visited[startX][startY] = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while (!queue.isEmpty()) {
            Pointer pointer = queue.poll();

            for(int i=0;i<4;i++) {
                int currentX = pointer.x + dx[i];
                int currentY = pointer.y + dy[i];

                if(currentX >= 0 && currentX < maps.length && currentY >= 0 && currentY < maps[0].length()
                        && !visited[currentX][currentY] && maps[currentX].charAt(currentY) != 'X') {
                    System.out.println(currentX + " / " + currentY + " / " + Integer.parseInt(String.valueOf(maps[currentX].charAt(currentY))));
                    visited[currentX][currentY] = true;
                    queue.add(new Pointer(currentX, currentY));
                    sum += Integer.parseInt(String.valueOf(maps[currentX].charAt(currentY)));
                }
            }

            if(queue.isEmpty()) {
                return sum;
            }
        }

        return -1;
    }

    public static class Pointer {
        int x;
        int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
