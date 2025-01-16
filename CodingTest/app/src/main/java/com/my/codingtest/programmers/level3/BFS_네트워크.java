package com.my.codingtest.programmers.level3;

import java.util.*;

public class BFS_네트워크 {
    public static void main(String[] args) {
        int n1 = 3;
        int[][] computers1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        // 2

        int n2 = 3;
        int[][] computers2 = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        // 1

        System.out.println(solution(n1, computers1));
    }

    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean[] visited;
    public static int count = 0;
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        for(int i=0;i<n;i++) {
            bfs(n, computers, i);
        }

        answer = count;

        return answer;
    }

    public static void bfs(int n, int[][] computers, int i) {
        System.out.println();
        if(visited[i]) {
            return;
        }
        count += 1;
        System.out.println("통과 " + i);
        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int q = queue.poll();
            for(int j=0;j<n;j++) {
                System.out.println(q + " / " + j);
                if(computers[q][j] == 1 && !visited[j]) {
                    System.out.println("통과");
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}
