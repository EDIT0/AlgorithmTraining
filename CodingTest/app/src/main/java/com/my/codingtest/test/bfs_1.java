package com.my.codingtest.test;

import java.util.LinkedList;
import java.util.Queue;

public class bfs_1 {
    public static void main(String[] args) {

        // 그래프를 2차원 배열로 표현해줍니다.
        // 배열의 인덱스를 노드와 매칭시켜서 사용하기 위해 인덱스 0은 아무것도 저장하지 않습니다.
        // 1번인덱스는 1번노드를 뜻하고 노드의 배열의 값은 연결된 노드들입니다.
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

        int[] result = bfs(1, graph, visited);

        for(int i=0;i<result.length;i++) {
            System.out.print(result[i] + " ");
        }

    }

    // BFS, 너비 우선 탐색
    public static int[] bfs(int start, int[][] graph, boolean[] visited) {
        int[] returnedArr = new int[graph.length - 1];

        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.offer(start);

        visited[start] = true;

        int idx = 0;
        while (!linkedList.isEmpty()) {
            int currentNode = (int) linkedList.poll();
            returnedArr[idx] = currentNode;
            for(int i=0;i<graph[currentNode].length;i++) {
                int tmp = graph[currentNode][i];
                if(visited[tmp] == false) {
                    visited[tmp] = true;
                    linkedList.offer(tmp);
                }
            }
            idx++;
        }

        return returnedArr;
    }
}
