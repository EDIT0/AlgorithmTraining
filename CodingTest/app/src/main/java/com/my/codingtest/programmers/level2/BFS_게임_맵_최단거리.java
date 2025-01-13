package com.my.codingtest.programmers.level2;

import java.util.*;

public class BFS_게임_맵_최단거리 {

    public static void main(String[] args) {
        int[][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        // 11

        int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        // -1

        System.out.println(solution(maps1));
    }

    public static int count = 0;
    public static int solution(int[][] maps) {
        int answer = 0;

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        bfs(maps, visited, 0, 0);

        if(count == 0) {
            answer = -1;
        } else {
            answer = count;
        }

        return answer;
    }

    public static void bfs(int[][] maps, boolean[][] visited, int startX, int startY) {
        visited[startX][startY] = true;

        Queue<Pointer> queue = new LinkedList<>();
        queue.add(new Pointer(startX, startY, 1));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Pointer pointer = queue.poll();
//            System.out.println(pointer.x + " / " + pointer.y + " || " + maps.length + " / " + maps[0].length);
            if(pointer.x == maps.length-1 && pointer.y == maps[0].length-1) {
                count = pointer.count;
                return;
            }

            for(int i=0;i<4;i++) {
                int newX = pointer.x + dx[i];
                int newY = pointer.y + dy[i];
                if(newX >= 0 && newY >= 0 && newY < maps[0].length && newX < maps.length && maps[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.add(new Pointer(newX, newY, pointer.count + 1));
                    visited[newX][newY] = true;
//                    System.out.println("방문: " + newX + " / " + newY);
                }
            }
        }

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
