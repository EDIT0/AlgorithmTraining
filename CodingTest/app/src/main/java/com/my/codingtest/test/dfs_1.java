package com.my.codingtest.test;

import java.util.LinkedList;
import java.util.Stack;

public class dfs_1 {

    public static void main(String[] args) {
        int[][] graph = {
                {},
                {2,3,8},
                {1,6,8},
                {1,5},
                {5,7},
                {3,4,7},
                {2},
                {4,5},
                {1,2}
        };

        // 방문처리를 위한 boolean배열 선언
        boolean[] visited = new boolean[9];

        int[] result = dfs(1, graph, visited);

        for(int i=0;i<result.length;i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] dfs(int start, int[][] graph, boolean[] visited) {
        int[] returnedArr = new int[graph.length - 1];

        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        int idx = 0;
        while (!stack.isEmpty()) {
            int pop = stack.pop();

            returnedArr[idx] = pop;

            // 현재 노드에 연결된 인접 노드를 역순으로 스택에 추가
            for(int i=graph[pop].length-1;i>=0;i--) {
                int tmp = graph[pop][i];
                boolean isVisited = visited[tmp];
                if(!isVisited) {
                    visited[tmp] = true;
                    stack.push(tmp);
                }
            }
            idx += 1;
        }

        return returnedArr;
    }


}
