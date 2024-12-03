package com.my.codingtest.programmers.level2;

import java.util.*;

public class BFS_숫자_변환하기 {

    public static void main(String[] args) {
        int x1 = 10;
        int y1 = 40;
        int n1 = 5;
        // 2

        int x2 = 10;
        int y2 = 40;
        int n2 = 30;
        // 1

        int x3 = 2;
        int y3 = 5;
        int n3 = 4;
        // -1

        System.out.println(solution(x1, y1, n1));
    }

    public static int solution(int x, int y, int n) {
        int answer = 0;

        Queue<Pointer> queue = new LinkedList<>();
        boolean[] visited = new boolean[y+1];

        queue.add(new Pointer(x, 0));

        while (!queue.isEmpty()) {
            Pointer pointer = queue.poll();

            System.out.println(pointer.sum + " / " + pointer.count);

            if(pointer.sum == y) {
                answer = pointer.count;
                return answer;
            }

            if(pointer.sum * 3 <= y) {
                if(!visited[pointer.sum * 3]) {
                    queue.add(new Pointer(pointer.sum * 3, pointer.count + 1));
                    visited[pointer.sum * 3] = true;
                }
            }
            if(pointer.sum * 2 <= y) {
                if(!visited[pointer.sum * 2]) {
                    queue.add(new Pointer(pointer.sum * 2, pointer.count + 1));
                    visited[pointer.sum * 2] = true;
                }

            }
            if(pointer.sum + n <= y) {
                if(!visited[pointer.sum + n]) {
                    queue.add(new Pointer(pointer.sum + n, pointer.count + 1));
                    visited[pointer.sum + n] = true;
                }
            }
        }

        return -1;
    }

    public static class Pointer {
        int sum = 0;
        int count = 0;

        Pointer(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

}
