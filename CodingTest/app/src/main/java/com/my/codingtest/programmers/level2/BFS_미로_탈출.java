package com.my.codingtest.programmers.level2;

import java.util.*;

public class BFS_미로_탈출 {
    public static void main(String[] args) {
        String[] maps1 = {
                "SOOOL",
                "XXXXO",
                "OOOOO",
                "OXXXX",
                "OOOOE"
        };
        // 16
        String[] maps2 = {
                "LOOXS",
                "OOOOX",
                "OOOOO",
                "OOOOO",
                "EOOOO"
        };
        // -1
        String[] maps3 = {"OOOOOL", "OXOXOO", "OOSXOX", "OXXXOX", "EOOOOX"};
        // 14
        String[] maps4 = {"XXXXXL", "XXXXOO", "OOSXOX", "OXXXOX", "EOOOOX"};
        // 22
        String[] maps5 = {"XXXXL", "XOOSX", "XXXXX", "XXXOO", "EXXXX", "XXXXX"};
        // -1
        String[] maps6 = {"SOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOLE"};
        // 8

        System.out.println(solution(maps6));
    }

    public static int gStartX = -1;
    public static int gStartY = -1;

    public static int solution(String[] maps) {
        int answer = 0;

        for(int i=0;i<maps.length;i++) {
            for(int j=0;j<maps[i].length();j++) {
                if(maps[i].charAt(j) == 'S') {
                    gStartX = i;
                    gStartY = j;
                    break;
                }
            }
            if(gStartX != -1) {
                break;
            }
        }

        int toL = bfs(gStartX, gStartY, maps, new boolean[maps.length][100], 'L');
        if(toL == -1) {
            return -1;
        }
        int toE = bfs(gStartX, gStartY, maps, new boolean[maps.length][100], 'E');
        if(toE == -1) {
            return -1;
        }
        answer = toL + toE;


        return answer;
    }

    public static int bfs(int startX, int startY, String[] maps, boolean[][] visited, char find) {
        Queue<Pointer> queue = new LinkedList<>();

        queue.add(new Pointer(startX, startY, 0));
        visited[startX][startY] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Pointer pointer = queue.poll();

            if(maps[pointer.x].charAt(pointer.y) == find) {
                gStartX = pointer.x;
                gStartY = pointer.y;
                return pointer.count;
            }

            for(int i=0;i<4;i++) {
                int currentX = pointer.x + dx[i];
                int currentY = pointer.y + dy[i];

                if(currentX >= 0 && currentY >= 0
                        && currentX < maps.length && currentY < maps[i].length()
                        && maps[currentX].charAt(currentY) != 'X'
                        && !visited[currentX][currentY]) {
                    visited[currentX][currentY] = true;
                    queue.add(new Pointer(currentX, currentY, pointer.count + 1));
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
