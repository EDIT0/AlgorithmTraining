package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 트리_s2_11725 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N;
    public static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    public static int[] parent;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1;i<=N+1;i++) {
            tree.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        bfs(1);

        for(int i=2;i<parent.length;i++) {
            bw.write(parent[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for(int i=0;i<tree.get(poll).size();i++) {
                int n = tree.get(poll).get(i);
                if(!visited[n]) {
                    visited[n] = true;
                    parent[n] = poll;
                    queue.offer(n);
                }
            }
        }
    }
//    public static int[][] tree;
//    public static boolean[] visited;
//    public static int N;
//    public static ArrayList<Model> list = new ArrayList<>();
//
//    public static void main(String[] args) throws IOException {
//        N = Integer.parseInt(br.readLine());
//
//        visited = new boolean[N+1];
//        tree = new int[N+1][2];
//
//        for(int i=1;i<=N-1;i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            tree[i][0] = a;
//            tree[i][1] = b;
//        }
//
//        bfs(1);
//
//        Collections.sort(list, (o1, o2) -> {
//            if(o1.node > o2.node) {
//                return 1;
//            } else if(o1.node < o2.node) {
//                return -1;
//            } else {
//                return 0;
//            }
//        });
//
//        for(int i=0;i<list.size();i++) {
//            bw.write(list.get(i).parentNode + "\n");
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    public static void bfs(int start) {
//        Queue<Integer> queue = new LinkedList<>();
//
//        queue.offer(start);
//
//        while (!queue.isEmpty()) {
//            int poll = queue.poll();
//
//            for(int i=1;i<=N;i++) {
//                if(poll == tree[i][0] && !visited[i]) {
//                    visited[i] = true;
//                    queue.offer(tree[i][1]);
//                    list.add(new Model(tree[i][1], poll));
//                } else if(poll == tree[i][1] && !visited[i]) {
//                    visited[i] = true;
//                    queue.offer(tree[i][0]);
//                    list.add(new Model(tree[i][0], poll));
//                }
//            }
//        }
//    }
//
//    public static class Model {
//        int node;
//        int parentNode;
//
//        Model(int n, int p) {
//            node = n;
//            parentNode = p;
//        }
//    }
}
