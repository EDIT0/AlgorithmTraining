package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s5_10451 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int T = Integer.parseInt(br.readLine());
            int N = 0;
            StringTokenizer st;
            int[] graph;
            boolean[] visited;
            int count;

            for(int i=0;i<T;i++) {
                N = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());
                graph = new int[N+1];
                visited = new boolean[N+1];
                count = 0;

                for(int j=1;j<=N;j++) {
                    graph[j] = Integer.parseInt(st.nextToken());
                }
                for(int k=1;k<=N;k++) {
                    if(bfs(k, graph, visited) != 0) {
                        count++;
                    }
                }
                bw.write(count + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    public static int bfs(int start, int[] graph, boolean[] visited) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.offer(start);

//        int idx = 0;
        int result = 0;
        while (!linkedList.isEmpty()) {
            int currentNode = (int) linkedList.poll();
            int tmp = graph[currentNode];
            if(visited[tmp] == false) {
//                System.out.print(tmp + "(" + idx + ") / ");
                visited[tmp] = true;
                linkedList.offer(tmp);
                result++;
            } else {
//                System.out.println("node finish");
            }
//            idx++;
        }

        return result;
    }
}
